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

public interface OpenApiVisitor {
    @Nullable
    OpenApiSpecification visitSpecificationStart(@Nonnull OpenApiSpecification specification);

    @Nullable
    OpenApiSpecification visitSpecificationEnd(@Nonnull OpenApiSpecification specification);

    @Nullable
    OpenApiPath visitPathStart(@Nonnull OpenApiPath path);

    @Nullable
    OpenApiPath visitPathEnd(@Nonnull OpenApiPath path);

    @Nullable
    OpenApiComponents visitComponentsStart(@Nonnull OpenApiComponents components);

    @Nullable
    OpenApiComponents visitComponentsEnd(@Nonnull OpenApiComponents components);

    @Nullable
    OpenApiOperation visitOperationStart(@Nonnull OpenApiOperation operation);

    @Nullable
    OpenApiOperation visitOperationEnd(@Nonnull OpenApiOperation operation);

    @Nullable
    OpenApiParameter visitParameterStart(@Nonnull OpenApiParameter parameter);

    @Nullable
    OpenApiParameter visitParameterEnd(@Nonnull OpenApiParameter parameter);

    @Nullable
    OpenApiSchema visitSchemaStart(@Nonnull OpenApiSchema schema);

    @Nullable
    OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema);

    @Nullable
    OpenApiDiscriminator visitDiscriminatorStart(@Nonnull OpenApiDiscriminator discriminator);

    @Nullable
    OpenApiDiscriminator visitDiscriminatorEnd(@Nonnull OpenApiDiscriminator discriminator);

    @Nullable
    OpenApiResponse visitResponseStart(@Nonnull OpenApiResponse response);

    @Nullable
    OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response);

    @Nullable
    OpenApiRequestBody visitRequestBodyStart(@Nonnull OpenApiRequestBody requestBody);

    @Nullable
    OpenApiRequestBody visitRequestBodyEnd(@Nonnull OpenApiRequestBody requestBody);

    @Nullable
    OpenApiResponses visitResponsesStart(@Nonnull OpenApiResponses responses);

    @Nullable
    OpenApiResponses visitResponsesEnd(@Nonnull OpenApiResponses responses);

    @Nullable
    OpenApiContent visitContentStart(@Nonnull OpenApiContent content);

    @Nullable
    OpenApiContent visitContentEnd(@Nonnull OpenApiContent content);

    @Nullable
    OpenApiMediaType visitMediaTypeStart(@Nonnull OpenApiMediaType schema);

    @Nullable
    OpenApiMediaType visitMediaTypeEnd(@Nonnull OpenApiMediaType schema);
}
