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
package software.amazon.opensearch.client.codegen.openapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class OpenApiSpecificationTests {
    @TempDir
    Path directory;

    @Test
    public void plainScalarsFollowYaml12CoreSchema() throws Exception {
        Path specification = directory.resolve("spec.yaml");
        Files.writeString(
            specification,
            String.join(
                "\n",
                "openapi: 3.1.0",
                "info:",
                "  title: test",
                "  version: 1.0.0",
                "paths: {}",
                "components:",
                "  schemas:",
                "    Decision:",
                "      type: string",
                "      enum:",
                "        - no",
                "        - yes",
                "        - NO",
                "        - YES",
                "        - y",
                "        - off",
                "    NoConst:",
                "      const: no",
                "    TrueConst:",
                "      const: true",
                ""
            )
        );

        Map<String, OpenApiSchema> schemas = OpenApiSpecification.retrieve(specification.toUri())
            .getComponents()
            .flatMap(OpenApiComponents::getSchemas)
            .orElseThrow();

        assertEquals(List.of("no", "yes", "NO", "YES", "y", "off"), schemas.get("Decision").getEnums().orElseThrow());
        assertEquals("no", schemas.get("NoConst").getConst().orElseThrow());
        assertEquals(Boolean.TRUE, schemas.get("TrueConst").getConst().orElseThrow());
    }
}
