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

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class SetBuilderBase<V, Builder extends SetBuilderBase<V, Builder>> extends ObjectBuilderBase<Set<V>, Builder> {
    @Nullable
    private Set<V> set;

    protected SetBuilderBase() {}

    @Override
    protected final @Nonnull Set<V> construct() {
        return _mutableSet(set);
    }

    public final @Nonnull Builder with(@Nonnull Set<V> set) {
        this.set = _setAddAll(this.set, set);
        return self();
    }

    @SafeVarargs
    public final @Nonnull Builder with(@Nonnull V value, @Nonnull V... values) {
        this.set = _setAdd(this.set, value, values);
        return self();
    }
}
