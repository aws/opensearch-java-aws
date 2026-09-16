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
package software.amazon.awssdk.opensearch.client.aoss.core.mget;

import software.amazon.awssdk.opensearch.client.aoss.core.get.GetResult;

/**
 * Builders for {@link MultiGetResponseItem} variants.
 */
public class MultiGetResponseItemBuilders {
    private MultiGetResponseItemBuilders() {}

    /**
     * Creates a builder for the {@link GetResult result}
     * {@code MultiGetResponseItem} variant.
     */
    public static <TDocument> GetResult.Builder<TDocument> result() {
        return new GetResult.Builder<TDocument>();
    }

    /**
     * Creates a builder for the {@link MultiGetError failure}
     * {@code MultiGetResponseItem} variant.
     */
    public static <TDocument> MultiGetError.Builder failure() {
        return new MultiGetError.Builder();
    }

}
