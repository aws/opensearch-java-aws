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
package software.amazon.awssdk.opensearch.client.codegen.utils.builder;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class ListBuilderBase<V, Builder extends ListBuilderBase<V, Builder>> extends ObjectBuilderBase<List<V>, Builder> {
    @Nullable
    private List<V> list;

    protected ListBuilderBase() {}

    @Override
    protected final @Nonnull List<V> construct() {
        return _mutableList(list);
    }

    public final @Nonnull Builder with(@Nonnull List<V> list) {
        this.list = _listAddAll(this.list, list);
        return self();
    }

    @SafeVarargs
    public final @Nonnull Builder with(@Nonnull V value, @Nonnull V... values) {
        this.list = _listAdd(this.list, value, values);
        return self();
    }
}
