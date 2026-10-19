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

import static org.junit.jupiter.api.Assertions.assertEquals;

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

public class OptionalGetBodyGenerationTests {
    @TempDir
    Path directory;

    @ParameterizedTest
    @CsvSource({
        "get,false,false,true",
        "get,true,false,false",
        "get,false,true,false",
        "post,false,false,false",
        "delete,false,false,false" })
    public void preservesBodyRequirementsThroughParsingCloningAndGeneration(
        String method,
        boolean requiredBody,
        boolean requiredField,
        boolean conditionalBody
    ) throws Exception {
        Path specification = directory.resolve("spec.yaml");
        Files.writeString(
            specification,
            String.format(
                String.join(
                    "\n",
                    "openapi: 3.0.3",
                    "info:",
                    "  title: Optional body test",
                    "  version: 1.0.0",
                    "paths:",
                    "  /example:",
                    "    %s:",
                    "      operationId: example.inspect.0",
                    "      description: Inspect an optional request body.",
                    "      x-operation-group: example.inspect",
                    "      requestBody:",
                    "        $ref: '#/components/requestBodies/body'",
                    "      responses:",
                    "        '200':",
                    "          description: Test response",
                    "          content:",
                    "            application/json:",
                    "              schema:",
                    "                type: object",
                    "                properties:",
                    "                  result:",
                    "                    type: string",
                    "components:",
                    "  requestBodies:",
                    "    body:",
                    "      required: %s",
                    "      content:",
                    "        application/json:",
                    "          schema:",
                    "            type: object",
                    "            required: %s",
                    "            properties:",
                    "              filter:",
                    "                type: string",
                    ""
                ),
                method,
                requiredBody,
                requiredField ? "[filter]" : "[]"
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
        String generated = Files.readString(output.resolve("example/InspectRequest.java"));
        assertEquals(conditionalBody, generated.contains("InspectRequest::hasBodyFields"));
    }
}
