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
package software.amazon.opensearch.client.codegen.openapi.walker;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.openapi.OpenApiComponents;
import software.amazon.opensearch.client.codegen.openapi.OpenApiContent;
import software.amazon.opensearch.client.codegen.openapi.OpenApiDiscriminator;
import software.amazon.opensearch.client.codegen.openapi.OpenApiMediaType;
import software.amazon.opensearch.client.codegen.openapi.OpenApiOperation;
import software.amazon.opensearch.client.codegen.openapi.OpenApiParameter;
import software.amazon.opensearch.client.codegen.openapi.OpenApiPath;
import software.amazon.opensearch.client.codegen.openapi.OpenApiRequestBody;
import software.amazon.opensearch.client.codegen.openapi.OpenApiResponse;
import software.amazon.opensearch.client.codegen.openapi.OpenApiResponses;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSpecification;

public abstract class OpenApiVisitorBase implements OpenApiVisitor {
    @Override
    @Nullable
    public OpenApiSpecification visitSpecificationStart(@Nonnull OpenApiSpecification specification) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiSpecification visitSpecificationEnd(@Nonnull OpenApiSpecification specification) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiPath visitPathStart(@Nonnull OpenApiPath path) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiPath visitPathEnd(@Nonnull OpenApiPath path) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiComponents visitComponentsStart(@Nonnull OpenApiComponents components) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiComponents visitComponentsEnd(@Nonnull OpenApiComponents components) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiOperation visitOperationStart(@Nonnull OpenApiOperation operation) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiOperation visitOperationEnd(@Nonnull OpenApiOperation operation) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiParameter visitParameterStart(@Nonnull OpenApiParameter parameter) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiParameter visitParameterEnd(@Nonnull OpenApiParameter parameter) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiSchema visitSchemaStart(@Nonnull OpenApiSchema schema) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiDiscriminator visitDiscriminatorStart(@Nonnull OpenApiDiscriminator discriminator) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiDiscriminator visitDiscriminatorEnd(@Nonnull OpenApiDiscriminator discriminator) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponse visitResponseStart(@Nonnull OpenApiResponse response) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiRequestBody visitRequestBodyStart(@Nonnull OpenApiRequestBody requestBody) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiRequestBody visitRequestBodyEnd(@Nonnull OpenApiRequestBody requestBody) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponses visitResponsesStart(@Nonnull OpenApiResponses responses) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiResponses visitResponsesEnd(@Nonnull OpenApiResponses responses) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiContent visitContentStart(@Nonnull OpenApiContent content) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiContent visitContentEnd(@Nonnull OpenApiContent content) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiMediaType visitMediaTypeStart(@Nonnull OpenApiMediaType schema) {
        return null;
    }

    @Override
    @Nullable
    public OpenApiMediaType visitMediaTypeEnd(@Nonnull OpenApiMediaType schema) {
        return null;
    }
}
