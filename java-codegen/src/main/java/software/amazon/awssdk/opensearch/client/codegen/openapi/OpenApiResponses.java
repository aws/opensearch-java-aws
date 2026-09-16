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
package software.amazon.awssdk.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.responses.ApiResponses;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.utils.builder.ToBuilder;

public final class OpenApiResponses extends OpenApiMapElement<OpenApiResponses, HttpStatusCode, OpenApiResponse>
    implements
        ToBuilder<OpenApiResponses.Builder> {
    private OpenApiResponses(@Nonnull Builder builder) {
        super(builder);
    }

    OpenApiResponses(@Nonnull ApiResponses responses) {
        super(responses, HttpStatusCode::from, OpenApiResponse::new);
    }

    @Override
    public @Nonnull OpenApiResponses clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return super.toBuilder(builder());
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends OpenApiMapElement.AbstractBuilder<
        OpenApiResponses,
        HttpStatusCode,
        OpenApiResponse,
        Builder> {
        private Builder() {}

        @Nonnull
        @Override
        public OpenApiResponses construct() {
            return new OpenApiResponses(this);
        }
    }
}
