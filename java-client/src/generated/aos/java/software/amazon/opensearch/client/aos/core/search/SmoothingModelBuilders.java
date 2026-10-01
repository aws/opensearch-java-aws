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

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */
//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.opensearch.client.aos.core.search;

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link SmoothingModel} variants.
 * </p>
 * <p>
 * Variants <code>laplace</code>, <code>linear_interpolation</code>, <code>stupid_backoff</code> are not available here as they don't have a
 * dedicated class. Use {@link SmoothingModel}'s builder for these.
 * </p>
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class SmoothingModelBuilders {
    private SmoothingModelBuilders() {}

    /**
     * Creates a builder for the {@link LaplaceSmoothingModel laplace} {@code SmoothingModel} variant.
     */
    public static LaplaceSmoothingModel.Builder laplace() {
        return new LaplaceSmoothingModel.Builder();
    }

    /**
     * Creates a builder for the {@link LinearInterpolationSmoothingModel linear_interpolation} {@code SmoothingModel} variant.
     */
    public static LinearInterpolationSmoothingModel.Builder linearInterpolation() {
        return new LinearInterpolationSmoothingModel.Builder();
    }

    /**
     * Creates a builder for the {@link StupidBackoffSmoothingModel stupid_backoff} {@code SmoothingModel} variant.
     */
    public static StupidBackoffSmoothingModel.Builder stupidBackoff() {
        return new StupidBackoffSmoothingModel.Builder();
    }
}
