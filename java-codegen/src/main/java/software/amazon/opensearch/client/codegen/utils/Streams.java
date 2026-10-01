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

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

public final class Streams {
    private Streams() {}

    @Nonnull
    public static <T, K extends Comparable<K>> Stream<T> sortedBy(@Nonnull Stream<T> stream, @Nonnull Function<T, K> keyExtractor) {
        Objects.requireNonNull(stream, "stream must not be null");
        Objects.requireNonNull(keyExtractor, "keyExtractor must not be null");
        return stream.sorted((a, b) -> {
            var ka = keyExtractor.apply(a);
            var kb = keyExtractor.apply(b);
            if (ka == null) return kb == null ? 0 : -1;
            if (kb == null) return 1;
            return ka.compareTo(kb);
        });
    }
}
