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
package org.opensearch.client.util;

import javax.annotation.Nonnull;

public interface CopyableBuilder<B extends CopyableBuilder<B, T>, T extends ToCopyableBuilder<B, T>> extends MutableBuilder<B, T> {
    /**
     * Create a new builder {@link B} that is a copy of this one.
     *
     * @return a new builder instance.
     *
     * @implNote The default implementation of this method calls {@link #build()} and then {@link T#toBuilder()}.
     *           Implementations can override this method to provide a more efficient implementation or to handle copying
     *           partial state.
     */
    @Nonnull
    default B copy() {
        return build().toBuilder();
    }
}
