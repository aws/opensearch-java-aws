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

package software.amazon.opensearch.client.aos._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: _types.ThreadInfo

/**
 * The information about thread usage.
 */
@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class ThreadInfo implements PlainJsonSerializable, ToCopyableBuilder<ThreadInfo.Builder, ThreadInfo> {

    @Nonnull
    private final Number activeThreads;

    @Nonnull
    private final Number threadExecutions;

    // ---------------------------------------------------------------------------------------------

    private ThreadInfo(Builder builder) {
        this.activeThreads = ApiTypeHelper.requireNonNull(builder.activeThreads, this, "activeThreads");
        this.threadExecutions = ApiTypeHelper.requireNonNull(builder.threadExecutions, this, "threadExecutions");
    }

    public static ThreadInfo of(Function<ThreadInfo.Builder, ObjectBuilder<ThreadInfo>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The number of currently active threads.
     * <p>
     * API name: {@code active_threads}
     * </p>
     */
    @Nonnull
    public final Number activeThreads() {
        return this.activeThreads;
    }

    /**
     * Required - The number of thread executions.
     * <p>
     * API name: {@code thread_executions}
     * </p>
     */
    @Nonnull
    public final Number threadExecutions() {
        return this.threadExecutions;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("active_threads");
        generator.write(this.activeThreads.doubleValue());

        generator.writeKey("thread_executions");
        generator.write(this.threadExecutions.doubleValue());
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link ThreadInfo}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ThreadInfo> {
        private Number activeThreads;
        private Number threadExecutions;

        public Builder() {}

        private Builder(ThreadInfo o) {
            this.activeThreads = o.activeThreads;
            this.threadExecutions = o.threadExecutions;
        }

        private Builder(Builder o) {
            this.activeThreads = o.activeThreads;
            this.threadExecutions = o.threadExecutions;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - The number of currently active threads.
         * <p>
         * API name: {@code active_threads}
         * </p>
         */
        @Nonnull
        public final Builder activeThreads(Number value) {
            this.activeThreads = value;
            return this;
        }

        /**
         * Required - The number of thread executions.
         * <p>
         * API name: {@code thread_executions}
         * </p>
         */
        @Nonnull
        public final Builder threadExecutions(Number value) {
            this.threadExecutions = value;
            return this;
        }

        /**
         * Builds a {@link ThreadInfo}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ThreadInfo build() {
            _checkSingleUse();

            return new ThreadInfo(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ThreadInfo}
     */
    public static final JsonpDeserializer<ThreadInfo> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ThreadInfo::setupThreadInfoDeserializer
    );

    protected static void setupThreadInfoDeserializer(ObjectDeserializer<ThreadInfo.Builder> op) {
        op.add(Builder::activeThreads, JsonpDeserializer.numberDeserializer(), "active_threads");
        op.add(Builder::threadExecutions, JsonpDeserializer.numberDeserializer(), "thread_executions");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.activeThreads.hashCode();
        result = 31 * result + this.threadExecutions.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ThreadInfo other = (ThreadInfo) o;
        return this.activeThreads.equals(other.activeThreads) && this.threadExecutions.equals(other.threadExecutions);
    }
}
