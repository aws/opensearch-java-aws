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
//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.opensearch.client.aos.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.json.JsonpDeserializable;
import software.amazon.opensearch.client.json.JsonpDeserializer;
import software.amazon.opensearch.client.json.JsonpMapper;
import software.amazon.opensearch.client.json.PlainJsonSerializable;
import software.amazon.opensearch.client.util.ApiTypeHelper;
import software.amazon.opensearch.client.util.CopyableBuilder;
import software.amazon.opensearch.client.util.ObjectBuilder;
import software.amazon.opensearch.client.util.ObjectBuilderBase;
import software.amazon.opensearch.client.util.ToCopyableBuilder;

// typedef: ml.get_all_tools.Response

@JsonpDeserializable
@Generated("software.amazon.opensearch.client.codegen.CodeGenerator")
public class GetAllToolsResponse implements PlainJsonSerializable, ToCopyableBuilder<GetAllToolsResponse.Builder, GetAllToolsResponse> {

    @Nonnull
    private final List<Tool> valueBody;

    // ---------------------------------------------------------------------------------------------

    private GetAllToolsResponse(Builder builder) {
        this.valueBody = ApiTypeHelper.unmodifiableRequired(builder.valueBody, this, "valueBody");
    }

    public static GetAllToolsResponse of(Function<GetAllToolsResponse.Builder, ObjectBuilder<GetAllToolsResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - Response value.
     */
    @Nonnull
    public final List<Tool> valueBody() {
        return this.valueBody;
    }

    /**
     * Serialize this value to JSON.
     */
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartArray();
        for (Tool item0 : this.valueBody) {
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
     * Builder for {@link GetAllToolsResponse}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, GetAllToolsResponse> {
        private List<Tool> valueBody;

        public Builder() {}

        private Builder(GetAllToolsResponse o) {
            this.valueBody = _listCopy(o.valueBody);
        }

        private Builder(Builder o) {
            this.valueBody = _listCopy(o.valueBody);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>valueBody</code>.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(List<Tool> list) {
            this.valueBody = _listAddAll(this.valueBody, list);
            return this;
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds one or more values to <code>valueBody</code>.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(Tool value, Tool... values) {
            this.valueBody = _listAdd(this.valueBody, value, values);
            return this;
        }

        /**
         * Required - Response value.
         *
         * <p>
         * Adds a value to <code>valueBody</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder valueBody(Function<Tool.Builder, ObjectBuilder<Tool>> fn) {
            return valueBody(fn.apply(new Tool.Builder()).build());
        }

        /**
         * Builds a {@link GetAllToolsResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public GetAllToolsResponse build() {
            _checkSingleUse();

            return new GetAllToolsResponse(this);
        }
    }

    public static final JsonpDeserializer<GetAllToolsResponse> _DESERIALIZER = createGetAllToolsResponseDeserializer();

    protected static JsonpDeserializer<GetAllToolsResponse> createGetAllToolsResponseDeserializer() {
        JsonpDeserializer<List<Tool>> valueDeserializer = JsonpDeserializer.arrayDeserializer(Tool._DESERIALIZER);

        return JsonpDeserializer.of(
            valueDeserializer.acceptedEvents(),
            (parser, mapper) -> new Builder().valueBody(valueDeserializer.deserialize(parser, mapper)).build()
        );
    }
}
