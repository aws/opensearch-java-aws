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
package software.amazon.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.parameters.RequestBody;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.utils.builder.ToBuilder;
import software.amazon.opensearch.client.codegen.utils.json.JsonGenerator;

public final class OpenApiRequestBody extends OpenApiOperationBodyElement<OpenApiRequestBody>
    implements
        ToBuilder<OpenApiRequestBody.Builder> {
    @Nullable
    private final Boolean required;

    private OpenApiRequestBody(@Nonnull OpenApiRequestBody.Builder builder) {
        super(builder, OpenApiRequestBody.class);
        required = builder.required;
    }

    OpenApiRequestBody(@Nonnull RequestBody requestBody) {
        super(requestBody.get$ref(), requestBody.getContent(), OpenApiRequestBody.class);
        required = requestBody.getRequired();
    }

    public boolean getRequired() {
        return Boolean.TRUE.equals(required);
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        super.toJsonInner(generator);
        if (required != null) {
            generator.writeField("required", required);
        }
    }

    @Override
    public @Nonnull OpenApiRequestBody clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder()).withRequired(required);
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiOperationBodyElement.AbstractBuilder<OpenApiRequestBody, Builder> {
        @Nullable
        private Boolean required;

        private Builder() {}

        @Nonnull
        public Builder withRequired(@Nullable Boolean required) {
            this.required = required;
            return this;
        }

        @Nonnull
        @Override
        public OpenApiRequestBody construct() {
            return new OpenApiRequestBody(this);
        }
    }
}
