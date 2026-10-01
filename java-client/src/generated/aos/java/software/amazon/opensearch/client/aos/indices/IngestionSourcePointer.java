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

package software.amazon.opensearch.client.aos.indices;

import jakarta.json.stream.JsonGenerator;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.ObjectBuilderDeserializer;
import software.amazon.opensearch.client.json.ObjectDeserializer;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.IngestionSourcePointer

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class IngestionSourcePointer
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<IngestionSourcePointer.Builder, IngestionSourcePointer> {

    @Nullable
    private final IngestionSourcePointerInit init;

    // ---------------------------------------------------------------------------------------------

    private IngestionSourcePointer(Builder builder) {
        this.init = builder.init;
    }

    public static IngestionSourcePointer of(Function<IngestionSourcePointer.Builder, ObjectBuilder<IngestionSourcePointer>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code init}
     */
    @Nullable
    public final IngestionSourcePointerInit init() {
        return this.init;
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
        if (this.init != null) {
            generator.writeKey("init");
            this.init.serialize(generator, mapper);
        }
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
     * Builder for {@link IngestionSourcePointer}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, IngestionSourcePointer> {
        @Nullable
        private IngestionSourcePointerInit init;

        public Builder() {}

        private Builder(IngestionSourcePointer o) {
            this.init = o.init;
        }

        private Builder(Builder o) {
            this.init = o.init;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code init}
         */
        @Nonnull
        public final Builder init(@Nullable IngestionSourcePointerInit value) {
            this.init = value;
            return this;
        }

        /**
         * API name: {@code init}
         */
        @Nonnull
        public final Builder init(Function<IngestionSourcePointerInit.Builder, ObjectBuilder<IngestionSourcePointerInit>> fn) {
            return init(fn.apply(new IngestionSourcePointerInit.Builder()).build());
        }

        /**
         * Builds a {@link IngestionSourcePointer}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public IngestionSourcePointer build() {
            _checkSingleUse();

            return new IngestionSourcePointer(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link IngestionSourcePointer}
     */
    public static final JsonpDeserializer<IngestionSourcePointer> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        IngestionSourcePointer::setupIngestionSourcePointerDeserializer
    );

    protected static void setupIngestionSourcePointerDeserializer(ObjectDeserializer<IngestionSourcePointer.Builder> op) {
        op.add(Builder::init, IngestionSourcePointerInit._DESERIALIZER, "init");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.init);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        IngestionSourcePointer other = (IngestionSourcePointer) o;
        return Objects.equals(this.init, other.init);
    }
}
