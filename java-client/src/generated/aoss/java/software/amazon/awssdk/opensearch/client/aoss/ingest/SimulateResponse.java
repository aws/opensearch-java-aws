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
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.aoss.ingest.simulate.PipelineSimulation;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializable;
import software.amazon.awssdk.opensearch.client.json.JsonpDeserializer;
import software.amazon.awssdk.opensearch.client.json.JsonpMapper;
import software.amazon.awssdk.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.awssdk.opensearch.client.json.ObjectDeserializer;
import software.amazon.awssdk.opensearch.client.json.PlainJsonSerializable;
import software.amazon.awssdk.opensearch.client.util.ApiTypeHelper;
import software.amazon.awssdk.opensearch.client.util.CopyableBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilder;
import software.amazon.awssdk.opensearch.client.util.ObjectBuilderBase;
import software.amazon.awssdk.opensearch.client.util.ToCopyableBuilder;

// typedef: ingest.simulate.Response

@JsonpDeserializable
@Generated("software.amazon.awssdk.opensearch.client.codegen.CodeGenerator")
public class SimulateResponse implements PlainJsonSerializable, ToCopyableBuilder<SimulateResponse.Builder, SimulateResponse> {

    @Nonnull
    private final List<PipelineSimulation> docs;

    // ---------------------------------------------------------------------------------------------

    private SimulateResponse(Builder builder) {
        this.docs = ApiTypeHelper.unmodifiableRequired(builder.docs, this, "docs");
    }

    public static SimulateResponse of(Function<SimulateResponse.Builder, ObjectBuilder<SimulateResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code docs}
     */
    @Nonnull
    public final List<PipelineSimulation> docs() {
        return this.docs;
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
        generator.writeKey("docs");
        generator.writeStartArray();
        for (PipelineSimulation item0 : this.docs) {
            item0.serialize(generator, mapper);
        }
        generator.writeEnd();
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
     * Builder for {@link SimulateResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, SimulateResponse> {
        private List<PipelineSimulation> docs;

        public Builder() {}

        private Builder(SimulateResponse o) {
            this.docs = _listCopy(o.docs);
        }

        private Builder(Builder o) {
            this.docs = _listCopy(o.docs);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code docs}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>docs</code>.
         * </p>
         */
        @Nonnull
        public final Builder docs(List<PipelineSimulation> list) {
            this.docs = _listAddAll(this.docs, list);
            return this;
        }

        /**
         * Required - API name: {@code docs}
         *
         * <p>
         * Adds one or more values to <code>docs</code>.
         * </p>
         */
        @Nonnull
        public final Builder docs(PipelineSimulation value, PipelineSimulation... values) {
            this.docs = _listAdd(this.docs, value, values);
            return this;
        }

        /**
         * Required - API name: {@code docs}
         *
         * <p>
         * Adds a value to <code>docs</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder docs(Function<PipelineSimulation.Builder, ObjectBuilder<PipelineSimulation>> fn) {
            return docs(fn.apply(new PipelineSimulation.Builder()).build());
        }

        /**
         * Builds a {@link SimulateResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public SimulateResponse build() {
            _checkSingleUse();

            return new SimulateResponse(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link SimulateResponse}
     */
    public static final JsonpDeserializer<SimulateResponse> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        SimulateResponse::setupSimulateResponseDeserializer
    );

    protected static void setupSimulateResponseDeserializer(ObjectDeserializer<SimulateResponse.Builder> op) {
        op.add(Builder::docs, JsonpDeserializer.arrayDeserializer(PipelineSimulation._DESERIALIZER), "docs");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.docs.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SimulateResponse other = (SimulateResponse) o;
        return this.docs.equals(other.docs);
    }
}
