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
import software.amazon.opensearch.client.codegen.utils.Versions;
import software.amazon.opensearch.client.codegen.utils.matcher.Matcher;

public class MaxVersionGenerationTests {
    @TempDir
    Path directory;

    @Test
    public void skipsOperationsAddedAfterMaxVersion() throws Exception {
        Path specification = directory.resolve("spec.yaml");
        Files.writeString(
            specification,
            String.join(
                "\n",
                "openapi: 3.0.3",
                "info:",
                "  title: Max version test",
                "  version: 1.0.0",
                "paths:",
                operation("/_old", "example.old.0", "example.old", "'1.0'"),
                operation("/_new", "example.new.0", "example.new", "'3.10'"),
                operation("/_mixed", "example.mixed.0", "example.mixed", "'2.0'"),
                operation("/_mixed/{id}", "example.mixed.1", "example.mixed", "'3.4'"),
                "components: {}",
                ""
            )
        );
        Overrides overrides = Overrides.builder().build();
        OpenApiSpecification spec = OpenApiSpecification.retrieve(specification.toUri()).clone();
        spec = SpecificationRewriter.rewrite(spec, overrides);
        SpecTransformer transformer = new SpecTransformer(
            Matcher.all(),
            overrides,
            CodegenSettings.DEFAULT_MODEL_PACKAGE,
            CodegenSettings.DEFAULT_ROOT_CLIENT_NAME,
            Versions.coerce("3.3")
        );
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
        assertTrue(Files.exists(output.resolve("example/OldRequest.java")));
        assertFalse(Files.exists(output.resolve("example/NewRequest.java")));
        String mixed = Files.readString(output.resolve("example/MixedRequest.java"));
        assertTrue(mixed.contains("\"/_mixed\""), mixed);
        assertFalse(mixed.contains("/_mixed/"), mixed);
    }

    @Test
    public void skipsFieldsAndCombinatorMembersAddedAfterMaxVersion() throws Exception {
        Path specification = directory.resolve("fields.yaml");
        Files.writeString(
            specification,
            String.join(
                "\n",
                "openapi: 3.1.0",
                "info:",
                "  title: Max version field test",
                "  version: 1.0.0",
                "paths:",
                "  /_thing:",
                "    get:",
                "      operationId: example.thing.0",
                "      x-operation-group: example.thing",
                "      description: Test operation.",
                "      responses:",
                "        '200':",
                "          description: Test response",
                "          content:",
                "            application/json:",
                "              schema:",
                "                $ref: '#/components/schemas/example___Thing'",
                "components:",
                "  schemas:",
                "    example___Thing:",
                "      type: object",
                "      properties:",
                "        old_field:",
                "          type: string",
                "        new_field:",
                "          type: string",
                "          x-version-added: '3.9'",
                "        shared_field:",
                "          type: string",
                "          x-version-added: '3.9'",
                "      allOf:",
                "        - anyOf:",
                "            - type: object",
                "              properties:",
                "                old_field:",
                "                  type: string",
                "                shared_field:",
                "                  type: string",
                "              required:",
                "                - old_field",
                "            - type: object",
                "              x-version-added: '3.9'",
                "              properties:",
                "                new_field:",
                "                  type: string",
                "              required:",
                "                - new_field",
                ""
            )
        );
        String thing = generate(specification, "3.3", "example/ThingResponse.java");

        assertTrue(thing.contains("public final String oldField()"), thing);
        // Only the available anyOf member remains, so old_field stays required.
        assertTrue(thing.contains("ApiTypeHelper.requireNonNull(builder.oldField, this, \"oldField\")"), thing);
        assertFalse(thing.contains("newField"), thing);
        // Also declared, without a version, by an available member.
        assertTrue(thing.contains("public final String sharedField()"), thing);

        String unfiltered = generate(specification, null, "example/ThingResponse.java");
        assertTrue(unfiltered.contains("public final String newField()"), unfiltered);
        assertFalse(unfiltered.contains("ApiTypeHelper.requireNonNull(builder.oldField"), unfiltered);
    }

    private String generate(Path specification, String maxVersion, String file) throws Exception {
        var version = maxVersion == null ? null : Versions.coerce(maxVersion);
        Overrides overrides = Overrides.builder().build();
        OpenApiSpecification spec = OpenApiSpecification.retrieve(specification.toUri()).clone();
        spec = SpecificationRewriter.rewrite(spec, overrides, version);
        SpecTransformer transformer = new SpecTransformer(
            Matcher.all(),
            overrides,
            CodegenSettings.DEFAULT_MODEL_PACKAGE,
            CodegenSettings.DEFAULT_ROOT_CLIENT_NAME,
            version
        );
        transformer.visit(spec);

        Path output = Files.createTempDirectory(directory, "generated");
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
        return Files.readString(output.resolve(file));
    }

    private static String operation(String path, String operationId, String group, String versionAdded) {
        return String.join(
            "\n",
            "  " + path + ":",
            "    get:",
            "      operationId: " + operationId,
            "      x-operation-group: " + group,
            "      x-version-added: " + versionAdded,
            "      description: Test operation.",
            path.contains("{id}")
                ? "      parameters:\n        - name: id\n          in: path\n          required: true\n          schema:\n            type: string"
                : "      parameters: []",
            "      responses:",
            "        '200':",
            "          description: Test response",
            "          content:",
            "            application/json:",
            "              schema:",
            "                type: object",
            "                properties:",
            "                  status:",
            "                    type: string"
        );
    }
}
