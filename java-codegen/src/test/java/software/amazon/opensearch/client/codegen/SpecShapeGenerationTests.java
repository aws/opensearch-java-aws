/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package software.amazon.opensearch.client.codegen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSpecification;
import software.amazon.opensearch.client.codegen.openapi.rewriter.SpecificationRewriter;
import software.amazon.opensearch.client.codegen.renderer.ShapeRenderingContext;
import software.amazon.opensearch.client.codegen.transformer.SpecTransformer;
import software.amazon.opensearch.client.codegen.transformer.overrides.Overrides;
import software.amazon.opensearch.client.codegen.utils.matcher.Matcher;

public class SpecShapeGenerationTests {
    @TempDir
    Path directory;

    @Test
    public void keepsGenericTypeParameterThroughReferenceCycle() throws Exception {
        var output = generate("getResponse", """
                example___TDocument:
                  x-is-generic-type-parameter: true
                example___Hit:
                  type: object
                  properties:
                    _source:
                      $ref: '#/components/schemas/example___TDocument'
                    inner_hits:
                      type: object
                      additionalProperties:
                        $ref: '#/components/schemas/example___InnerHitsResult'
                example___InnerHitsResult:
                  type: object
                  properties:
                    hits:
                      $ref: '#/components/schemas/example___HitsMetadata'
                example___HitsMetadata:
                  type: object
                  properties:
                    hits:
                      type: array
                      items:
                        allOf:
                          - $ref: '#/components/schemas/example___Hit'
                          - type: object
                            properties:
                              _source:
                                $ref: '#/components/schemas/example___TDocument'
                example___HitsMetadataJsonValue:
                  allOf:
                    - $ref: '#/components/schemas/example___HitsMetadata'
                    - type: object
                      properties:
                        hits:
                          type: array
                          items:
                            allOf:
                              - $ref: '#/components/schemas/example___Hit'
                              - type: object
                                properties:
                                  _source: {}
                example___getResponse:
                  type: object
                  properties:
                    hits:
                      $ref: '#/components/schemas/example___HitsMetadataJsonValue'
            """);

        var hitsMetadata = Files.readString(output.resolve("example/HitsMetadata.java"));
        assertTrue(hitsMetadata.contains("public class HitsMetadata<TDocument>"), hitsMetadata);
        assertTrue(hitsMetadata.contains("private final List<Hit<TDocument>> hits;"), hitsMetadata);
        var innerHitsResult = Files.readString(output.resolve("example/InnerHitsResult.java"));
        assertTrue(innerHitsResult.contains("private final HitsMetadata<JsonData> hits;"), innerHitsResult);
    }

    @Test
    public void flattensSchemaExtendingDirectlyUsedSchema() throws Exception {
        var output = generate("getResponse", """
                example___Allocation:
                  type: object
                  properties:
                    enable:
                      type: string
                example___ClusterAllocation:
                  allOf:
                    - $ref: '#/components/schemas/example___Allocation'
                    - type: object
                      properties:
                        awareness:
                          type: string
                example___getResponse:
                  type: object
                  properties:
                    index:
                      $ref: '#/components/schemas/example___Allocation'
                    cluster:
                      $ref: '#/components/schemas/example___ClusterAllocation'
            """);

        var cluster = Files.readString(output.resolve("example/ClusterAllocation.java"));
        assertFalse(cluster.contains("extends Allocation"), cluster);
        assertTrue(cluster.contains("private final String enable;"), cluster);
        assertTrue(cluster.contains("private final String awareness;"), cluster);
    }

    @Test
    public void flattensDiscriminatedRequestBody() throws Exception {
        var output = generate("getResponse", """
                example___Base:
                  type: object
                  properties:
                    name:
                      type: string
                  required:
                    - name
                example___First:
                  allOf:
                    - $ref: '#/components/schemas/example___Base'
                    - type: object
                      properties:
                        type:
                          type: string
                      required:
                        - type
                example___Second:
                  allOf:
                    - $ref: '#/components/schemas/example___Base'
                    - type: object
                      properties:
                        type:
                          type: string
                        size:
                          type: integer
                      required:
                        - type
                example___getResponse:
                  type: object
                  properties:
                    status:
                      type: string
            """, """
                  requestBody:
                    content:
                      application/json:
                        schema:
                          discriminator:
                            propertyName: type
                          oneOf:
                            - $ref: '#/components/schemas/example___First'
                            - $ref: '#/components/schemas/example___Second'
            """);

        var request = Files.readString(output.resolve("example/GetExampleRequest.java"));
        assertTrue(request.contains("private final String name;"), request);
        assertTrue(request.contains("private final String type;"), request);
        assertTrue(request.contains("private final Integer size;"), request);
    }

    private Path generate(String responseSchema, String schemas) throws Exception {
        return generate(responseSchema, schemas, "");
    }

    private Path generate(String responseSchema, String schemas, String requestBody) throws Exception {
        Path specification = directory.resolve("spec.yaml");
        var spec = String.join(
            "\n",
            "openapi: 3.0.3",
            "info:",
            "  title: Shape generation test",
            "  version: 1.0.0",
            "paths:",
            "  /example:",
            "    post:",
            "      operationId: example.get.0",
            "      description: Get an example.",
            "      x-operation-group: example.get",
            yaml(requestBody, 6),
            "      responses:",
            "        '200':",
            "          description: Test response",
            "          content:",
            "            application/json:",
            "              schema:",
            "                $ref: '#/components/schemas/example___" + responseSchema + "'",
            "components:",
            "  schemas:",
            yaml(schemas, 4)
        );
        Files.writeString(specification, spec);
        Overrides overrides = Overrides.builder().build();
        OpenApiSpecification parsed = OpenApiSpecification.retrieve(specification.toUri()).clone();
        parsed = SpecificationRewriter.rewrite(parsed, overrides);
        SpecTransformer transformer = new SpecTransformer(Matcher.all(), overrides);
        transformer.visit(parsed);

        Path output = directory.resolve("generated");
        try (
            ShapeRenderingContext context = ShapeRenderingContext.builder()
                .withOutputDir(output.toFile())
                .withJavaCodeFormatter(
                    b -> b.withRootDir(output).withEclipseFormatterConfig(Path.of("../buildSrc/formatterConfig.xml").toFile())
                )
                .withTemplateLoader(b -> b.withTemplatesResourceSubPath("/software/amazon/opensearch/client/codegen/templates"))
                .build()
        ) {
            transformer.getRoot().render(context);
        }
        return output;
    }

    private static String yaml(String fragment, int indent) {
        return fragment.stripTrailing().stripIndent().indent(indent).stripTrailing();
    }
}
