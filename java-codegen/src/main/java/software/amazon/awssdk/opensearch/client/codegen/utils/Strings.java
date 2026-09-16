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
package software.amazon.awssdk.opensearch.client.codegen.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.text.CaseUtils;
import org.jetbrains.annotations.Contract;

public final class Strings {
    private Strings() {}

    public static boolean isNullOrEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNullOrBlank(@Nullable String str) {
        return str == null || str.isBlank();
    }

    @Nonnull
    @Contract(value = "null, _ -> fail; _, _ -> param1", pure = true)
    public static String requireNonBlank(@Nullable String str, @Nullable String message) {
        if (isNullOrBlank(str)) {
            throw new IllegalArgumentException(message);
        }
        return str;
    }

    private static final Map<String, String> SPECIAL_CASE_SNAKE_CASE_CONVERSION = new HashMap<>() {
        {
            put("noop", "no_op");
        }
    };

    @Nonnull
    public static String toSnakeCase(@Nonnull String str) {
        Objects.requireNonNull(str, "str must not be null");
        if (str.isEmpty()) {
            return str;
        }

        var specialCase = SPECIAL_CASE_SNAKE_CASE_CONVERSION.get(str);
        if (specialCase != null) return specialCase;

        return str.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
            .replaceAll("([a-z\\d])([A-Z])", "$1_$2")
            .replaceAll("(\\s|[-:.])", "_")
            .toLowerCase(Locale.US);
    }

    @Nonnull
    private static String toCamelCase(@Nonnull String str, boolean capitalizeFirstLetter) {
        return CaseUtils.toCamelCase(toSnakeCase(str), capitalizeFirstLetter, '_');
    }

    @Nonnull
    public static String toCamelCase(@Nonnull String str) {
        return toCamelCase(str, false);
    }

    @Nonnull
    public static String toPascalCase(@Nonnull String str) {
        return toCamelCase(str, true);
    }

    @Nonnull
    public static <T> String join(@Nonnull Collection<T> items, @Nonnull String delimiter, @Nonnull Function<T, String> mapper) {
        Objects.requireNonNull(items, "items must not be null");
        Objects.requireNonNull(delimiter, "delimiter must not be null");
        Objects.requireNonNull(mapper, "mapper must not be null");

        return items.stream().map(mapper).collect(Collectors.joining(delimiter));
    }
}
