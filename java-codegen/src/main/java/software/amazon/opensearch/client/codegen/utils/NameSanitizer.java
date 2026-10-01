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

import java.util.Set;
import javax.annotation.Nonnull;

public class NameSanitizer {
    private static final Set<String> reservedWords = Set.of(
        "default",
        "if",
        "interface",
        "native",
        "transient",
        "boolean",
        "char",
        "byte",
        "short",
        "int",
        "long",
        "float",
        "double",
        "static"
    );

    @Nonnull
    public static String fieldName(@Nonnull String name) {
        name = Strings.toCamelCase(name);
        if (reservedWords.contains(name)) {
            name += "_";
        }
        if (Character.isDigit(name.charAt(0))) {
            name = "_" + name;
        }
        return name;
    }
}
