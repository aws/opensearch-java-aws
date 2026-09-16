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
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.annotation.Nonnull;

public class Memoizer<I, O> {
    @Nonnull
    private final Map<I, O> cache = new ConcurrentHashMap<>();
    @Nonnull
    private final Set<I> calculating = ConcurrentHashMap.newKeySet();
    @Nonnull
    private final Function<I, O> getter;

    public Memoizer(@Nonnull Function<I, O> getter) {
        this.getter = Objects.requireNonNull(getter, "getter cannot be null");
    }

    @Nonnull
    public O get(@Nonnull I input) {
        if (cache.containsKey(Objects.requireNonNull(input, "input cannot be null"))) {
            return cache.get(input);
        }
        var alreadyCalculating = !calculating.add(input);
        var result = getter.apply(input);
        if (!alreadyCalculating) {
            cache.put(input, result);
            calculating.remove(input);
        }
        return result;
    }
}
