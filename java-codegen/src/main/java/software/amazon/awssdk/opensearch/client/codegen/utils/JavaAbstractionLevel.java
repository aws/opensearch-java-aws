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

public enum JavaAbstractionLevel {
    Abstract("abstract"),
    Concrete(""),
    Final("final");

    private static final Map<String, JavaAbstractionLevel> VALUES = Maps.createLookupOf(values(), JavaAbstractionLevel::toString);

    private final String value;

    JavaAbstractionLevel(String value) {
        this.value = value;
    }

    @Nonnull
    public static JavaAbstractionLevel from(@Nonnull String level) {
        var value = VALUES.get(Strings.requireNonBlank(level, "level must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown level: " + level);
        }
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
