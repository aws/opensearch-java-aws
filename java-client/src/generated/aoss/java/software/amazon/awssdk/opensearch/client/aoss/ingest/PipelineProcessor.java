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

package software.amazon.awssdk.opensearch.client.aoss.ingest;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.PipelineProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PipelineProcessor extends ProcessorBase
    implements
        ProcessorVariant,
        ToCopyableBuilder<PipelineProcessor.Builder, PipelineProcessor> {

    @Nullable
    private final Boolean ignoreMissingPipeline;

    @Nonnull
    private final String name;

    // ---------------------------------------------------------------------------------------------

    private PipelineProcessor(Builder builder) {
        super(builder);
        this.ignoreMissingPipeline = builder.ignoreMissingPipeline;
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
    }

    public static PipelineProcessor of(Function<PipelineProcessor.Builder, ObjectBuilder<PipelineProcessor>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link Processor} variant kind.
     */
    @Override
    public Processor.Kind _processorKind() {
        return Processor.Kind.Pipeline;
    }

    /**
     * Whether to ignore missing pipelines instead of failing.
     * <p>
     * API name: {@code ignore_missing_pipeline}
     * </p>
     */
    @Nullable
    public final Boolean ignoreMissingPipeline() {
        return this.ignoreMissingPipeline;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        super.serializeInternal(generator, mapper);
        if (this.ignoreMissingPipeline != null) {
            generator.writeKey("ignore_missing_pipeline");
            generator.write(this.ignoreMissingPipeline);
        }

        generator.writeKey("name");
        generator.write(this.name);
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
     * Builder for {@link PipelineProcessor}.
     */
    public static class Builder extends ProcessorBase.AbstractBuilder<Builder> implements CopyableBuilder<Builder, PipelineProcessor> {
        @Nullable
        private Boolean ignoreMissingPipeline;
        private String name;

        public Builder() {}

        private Builder(PipelineProcessor o) {
            super(o);
            this.ignoreMissingPipeline = o.ignoreMissingPipeline;
            this.name = o.name;
        }

        private Builder(Builder o) {
            super(o);
            this.ignoreMissingPipeline = o.ignoreMissingPipeline;
            this.name = o.name;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        @Override
        @Nonnull
        protected Builder self() {
            return this;
        }

        /**
         * Whether to ignore missing pipelines instead of failing.
         * <p>
         * API name: {@code ignore_missing_pipeline}
         * </p>
         */
        @Nonnull
        public final Builder ignoreMissingPipeline(@Nullable Boolean value) {
            this.ignoreMissingPipeline = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Builds a {@link PipelineProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PipelineProcessor build() {
            _checkSingleUse();

            return new PipelineProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PipelineProcessor}
     */
    public static final JsonpDeserializer<PipelineProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PipelineProcessor::setupPipelineProcessorDeserializer
    );

    protected static void setupPipelineProcessorDeserializer(ObjectDeserializer<PipelineProcessor.Builder> op) {
        setupProcessorBaseDeserializer(op);
        op.add(Builder::ignoreMissingPipeline, JsonpDeserializer.booleanDeserializer(), "ignore_missing_pipeline");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.ignoreMissingPipeline);
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PipelineProcessor other = (PipelineProcessor) o;
        return Objects.equals(this.ignoreMissingPipeline, other.ignoreMissingPipeline) && this.name.equals(other.name);
    }
}
