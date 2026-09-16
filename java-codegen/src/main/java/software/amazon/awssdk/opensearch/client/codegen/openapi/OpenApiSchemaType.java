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
package software.amazon.awssdk.opensearch.client.codegen.openapi;

import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.utils.Maps;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;

public enum OpenApiSchemaType {
    Array,
    Boolean,
    Integer,
    Null,
    Number,
    Object,
    String;

    public static final Set<OpenApiSchemaType> ALL_TYPES = Set.of(values());
    private static final Map<String, OpenApiSchemaType> VALUES = Maps.createLookupOf(values(), OpenApiSchemaType::toString);

    @Nonnull
    public static OpenApiSchemaType from(@Nonnull String type) {
        var value = VALUES.get(Strings.requireNonBlank(type, "type must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
        return value;
    }

    @Override
    public java.lang.String toString() {
        return name().toLowerCase();
    }
}
