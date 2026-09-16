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

import java.util.Map;
import javax.annotation.Nonnull;

public enum JavaClassKind {
    Class,
    Enum,
    Interface;

    private static final Map<String, JavaClassKind> VALUES = Maps.createLookupOf(values(), JavaClassKind::toString);

    @Nonnull
    public static JavaClassKind from(@Nonnull String kind) {
        var value = VALUES.get(Strings.requireNonBlank(kind, "kind must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown kind: " + kind);
        }
        return value;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
