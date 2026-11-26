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

package software.amazon.opensearch.client.aos.ism;

import javax.annotation.Generated;
import software.amazon.opensearch.client.aos._types.Time;

/**
 * <p>
 * Builders for {@link TransitionConditions} variants.
 * </p>
 * <p>
 * Variants <code>cron</code>, <code>min_doc_count</code>, <code>min_index_age</code>, <code>min_rollover_age</code>, <code>min_size</code>,
 * <code>min_state_age</code>, <code>no_alias</code> are not available here as they don't have a dedicated class. Use
 * {@link TransitionConditions}'s builder for these.
 * </p>
 */
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class TransitionConditionsBuilders {
    private TransitionConditionsBuilders() {}

    /**
     * Creates a builder for the {@link TransitionCron cron} {@code TransitionConditions} variant.
     */
    public static TransitionCron.Builder cron() {
        return new TransitionCron.Builder();
    }

    /**
     * Creates a builder for the {@link Time min_index_age} {@code TransitionConditions} variant.
     */
    public static Time.Builder minIndexAge() {
        return new Time.Builder();
    }

    /**
     * Creates a builder for the {@link Time min_rollover_age} {@code TransitionConditions} variant.
     */
    public static Time.Builder minRolloverAge() {
        return new Time.Builder();
    }

    /**
     * Creates a builder for the {@link Time min_state_age} {@code TransitionConditions} variant.
     */
    public static Time.Builder minStateAge() {
        return new Time.Builder();
    }
}
