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
package software.amazon.awssdk.opensearch.client.util;

import java.util.function.Consumer;
import javax.annotation.Nonnull;

public interface ToCopyableBuilder<B extends CopyableBuilder<B, T>, T extends ToCopyableBuilder<B, T>> {
    /**
     * Create a new builder {@link B} that is initialised with the current state of this object.
     *
     * @return a new builder instance.
     */
    @Nonnull
    B toBuilder();

    /**
     * A convenience method for calling {@link #toBuilder()}, updating the returned builder and then calling {@link B#build()}.
     *
     * @param modifier A function that mutates this immutable object using the provided builder.
     * @return A new copy of this object with the requested modifications.
     */
    @Nonnull
    default T copy(@Nonnull Consumer<? super B> modifier) {
        return toBuilder().applyMutation(modifier).build();
    }
}
