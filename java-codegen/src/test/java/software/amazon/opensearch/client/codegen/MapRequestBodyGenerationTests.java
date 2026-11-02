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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSpecification;
import software.amazon.opensearch.client.codegen.openapi.rewriter.SpecificationRewriter;
import software.amazon.opensearch.client.codegen.renderer.ShapeRenderingContext;
import software.amazon.opensearch.client.codegen.transformer.SpecTransformer;
import software.amazon.opensearch.client.codegen.transformer.overrides.Overrides;
import software.amazon.opensearch.client.codegen.utils.matcher.Matcher;

public class MapRequestBodyGenerationTests {
    @TempDir
    Path directory;

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
        "\"$ref\": \"#/components/schemas/example___Definition\"|Map<String, Definition> body",
        "true|Map<String, JsonData> body" })
    public void generatesRequiredBodyForAdditionalPropertiesOnlyObject(String additionalProperties, String expectedField) throws Exception {
        Path specification = directory.resolve("spec.yaml");
        Files.writeString(
            specification,
            String.join(
                "\n",
                "openapi: 3.0.3",
                "info:",
                "  title: Map body test",
                "  version: 1.0.0",
                "paths:",
                "  /example:",
                "    put:",
                "      operationId: example.put_all.0",
                "      description: Create or replace definitions.",
                "      x-operation-group: example.put_all",
                "      requestBody:",
                "        required: true",
                "        content:",
                "          application/json:",
                "            schema:",
                "              type: object",
                "              minProperties: 1",
                "              additionalProperties: { " + additionalProperties + " }".replace("{ true }", "true"),
                "      responses:",
                "        '200':",
                "          description: Test response",
                "          content:",
                "            application/json:",
                "              schema:",
                "                type: object",
                "                properties:",
                "                  status:",
                "                    type: string",
                "components:",
                "  schemas:",
                "    example___Definition:",
                "      type: object",
                "      properties:",
                "        description:",
                "          type: string",
                ""
            )
        );
        Overrides overrides = Overrides.builder().build();
        OpenApiSpecification spec = OpenApiSpecification.retrieve(specification.toUri()).clone();
        spec = SpecificationRewriter.rewrite(spec, overrides);
        SpecTransformer transformer = new SpecTransformer(Matcher.all(), overrides);
        transformer.visit(spec);

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
        String generated = Files.readString(output.resolve("example/PutAllRequest.java"));
        assertTrue(generated.contains("private final " + expectedField + ";"), generated);
        assertTrue(generated.contains("ApiTypeHelper.unmodifiableRequired(builder.body, this, \"body\")"), generated);
        assertTrue(generated.replaceAll("\\s+", " ").contains("SimpleEndpoint.emptyMap(), true,"), generated);
    }
}
