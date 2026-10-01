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

import jakarta.json.stream.JsonGenerator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonData;
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

// typedef: ism.ActionTimeout

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class ActionTimeout implements PlainJsonSerializable, ToCopyableBuilder<ActionTimeout.Builder, ActionTimeout> {

    @Nonnull
    private final Map<String, JsonData> timeout;

    // ---------------------------------------------------------------------------------------------

    private ActionTimeout(Builder builder) {
        this.timeout = ApiTypeHelper.unmodifiable(builder.timeout);
    }

    public static ActionTimeout of(Function<ActionTimeout.Builder, ObjectBuilder<ActionTimeout>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The timeout configuration for the action.
     * <p>
     * API name: {@code timeout}
     * </p>
     */
    @Nonnull
    public final Map<String, JsonData> timeout() {
        return this.timeout;
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
        if (ApiTypeHelper.isDefined(this.timeout)) {
            generator.writeKey("timeout");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.timeout.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
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
     * Builder for {@link ActionTimeout}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ActionTimeout> {
        @Nullable
        private Map<String, JsonData> timeout;

        public Builder() {}

        private Builder(ActionTimeout o) {
            this.timeout = _mapCopy(o.timeout);
        }

        private Builder(Builder o) {
            this.timeout = _mapCopy(o.timeout);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The timeout configuration for the action.
         * <p>
         * API name: {@code timeout}
         * </p>
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>timeout</code>.
         * </p>
         */
        @Nonnull
        public final Builder timeout(Map<String, JsonData> map) {
            this.timeout = _mapPutAll(this.timeout, map);
            return this;
        }

        /**
         * The timeout configuration for the action.
         * <p>
         * API name: {@code timeout}
         * </p>
         *
         * <p>
         * Adds an entry to <code>timeout</code>.
         * </p>
         */
        @Nonnull
        public final Builder timeout(String key, JsonData value) {
            this.timeout = _mapPut(this.timeout, key, value);
            return this;
        }

        /**
         * Builds a {@link ActionTimeout}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ActionTimeout build() {
            _checkSingleUse();

            return new ActionTimeout(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ActionTimeout}
     */
    public static final JsonpDeserializer<ActionTimeout> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ActionTimeout::setupActionTimeoutDeserializer
    );

    protected static void setupActionTimeoutDeserializer(ObjectDeserializer<ActionTimeout.Builder> op) {
        op.add(Builder::timeout, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "timeout");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.timeout);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ActionTimeout other = (ActionTimeout) o;
        return Objects.equals(this.timeout, other.timeout);
    }
}
