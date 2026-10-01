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
package software.amazon.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

public class MavenArtifactResolverTests {
    @Test
    public void resolves() throws IOException {
        // https://repo.maven.apache.org/maven2/com/google/code/findbugs/jsr305/3.0.2/
        final var group = "com.google.code.findbugs";
        final var name = "jsr305";
        final var version = "3.0.2";
        final var md5Sum = "dd83accb899363c32b07d7a1b2e4ce40";
        final var fileSize = 19936;

        final var coordinates = group + ":" + name + ":" + version;
        final var fileSubPath = Stream.concat(Arrays.stream(group.split("\\.")), Stream.of(name, version, name + "-" + version + ".jar"))
            .collect(Collectors.joining(File.separator));

        var files = MavenArtifactResolver.createDefault().resolve(false, Collections.singleton(coordinates));
        assertEquals(1, files.size());

        var file = files.iterator().next();

        assertTrue(file.getAbsolutePath().endsWith(fileSubPath));
        assertTrue(file.exists());
        assertEquals(fileSize, file.length());

        try (var is = new FileInputStream(file)) {
            assertEquals(md5Sum, DigestUtils.md5Hex(is));
        }
    }
}
