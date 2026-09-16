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

package software.amazon.awssdk.opensearch.client.aos._types;

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link BulkByScrollTaskStatusOrException} variants.
 * </p>
 * <p>
 * Variants <code>exception</code>, <code>status</code> are not available here as they don't have a dedicated class. Use
 * {@link BulkByScrollTaskStatusOrException}'s builder for these.
 * </p>
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class BulkByScrollTaskStatusOrExceptionBuilders {
    private BulkByScrollTaskStatusOrExceptionBuilders() {}

    /**
     * Creates a builder for the {@link ErrorCause exception} {@code BulkByScrollTaskStatusOrException} variant.
     */
    public static ErrorCause.Builder exception() {
        return new ErrorCause.Builder();
    }

    /**
     * Creates a builder for the {@link BulkByScrollTaskStatus status} {@code BulkByScrollTaskStatusOrException} variant.
     */
    public static BulkByScrollTaskStatus.Builder status() {
        return new BulkByScrollTaskStatus.Builder();
    }
}
