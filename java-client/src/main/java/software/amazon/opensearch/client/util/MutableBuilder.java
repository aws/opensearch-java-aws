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
package software.amazon.opensearch.client.util;

import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nonnull;

public interface MutableBuilder<B extends MutableBuilder<B, T>, T> extends ObjectBuilder<T> {
    /**
     * Apply a mutation to this object.
     *
     * @param mutator the mutation to apply
     * @return this object
     */
    @SuppressWarnings("unchecked")
    @Nonnull
    default B applyMutation(@Nonnull Consumer<? super B> mutator) {
        Objects.requireNonNull(mutator, "mutator must not be null").accept((B) this);
        return (B) this;
    }
}
