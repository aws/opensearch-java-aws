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
package software.amazon.opensearch.client.codegen.utils.builder;

import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class MapBuilderBase<K, V, Builder extends MapBuilderBase<K, V, Builder>> extends ObjectBuilderBase<Map<K, V>, Builder> {
    @Nullable
    private Map<K, V> map;

    protected MapBuilderBase() {}

    @Override
    protected final @Nonnull Map<K, V> construct() {
        return _mutableMap(map);
    }

    public final @Nonnull Builder with(@Nonnull Map<K, V> map) {
        this.map = _mapPutAll(this.map, map);
        return self();
    }

    public final @Nonnull Builder with(@Nonnull K key, @Nonnull V value) {
        this.map = _mapPut(this.map, key, value);
        return self();
    }
}
