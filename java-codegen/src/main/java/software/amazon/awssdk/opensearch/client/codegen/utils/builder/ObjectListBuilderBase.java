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

import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;

public abstract class ObjectListBuilderBase<
    V,
    VBuilder extends ObjectBuilder<V>,
    Builder extends ObjectListBuilderBase<V, VBuilder, Builder>> extends ListBuilderBase<V, Builder> {
    protected ObjectListBuilderBase() {}

    protected abstract @Nonnull VBuilder valueBuilder();

    public final @Nonnull Builder with(@Nonnull Function<VBuilder, ObjectBuilder<V>> fn) {
        return with(Objects.requireNonNull(fn, "fn must not be null").apply(valueBuilder()).build());
    }
}
