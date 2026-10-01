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

import javax.annotation.Nonnull;
import org.semver4j.Semver;

public final class Versions {
    private Versions() {}

    public static final Semver V1_0_0 = Semver.of(1, 0, 0);
    public static final Semver V2_0_0 = Semver.of(2, 0, 0);

    @Nonnull
    public static Semver coerce(String str) {
        var version = Semver.coerce(str);
        if (version == null) throw new IllegalArgumentException("Unable to coerce `" + str + "` to semver");
        return version;
    }
}
