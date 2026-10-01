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
package software.amazon.opensearch.client.codegen.openapi.rewriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.codegen.openapi.OpenApiComponents;
import software.amazon.opensearch.client.codegen.openapi.OpenApiContent;
import software.amazon.opensearch.client.codegen.openapi.OpenApiDiscriminator;
import software.amazon.opensearch.client.codegen.openapi.OpenApiElement;
import software.amazon.opensearch.client.codegen.openapi.OpenApiMediaType;
import software.amazon.opensearch.client.codegen.openapi.OpenApiOperation;
import software.amazon.opensearch.client.codegen.openapi.OpenApiParameter;
import software.amazon.opensearch.client.codegen.openapi.OpenApiPath;
import software.amazon.opensearch.client.codegen.openapi.OpenApiRequestBody;
import software.amazon.opensearch.client.codegen.openapi.OpenApiResponse;
import software.amazon.opensearch.client.codegen.openapi.OpenApiResponses;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSpecification;
import software.amazon.opensearch.client.codegen.openapi.walker.OpenApiVisitor;

public final class VisitorChain implements OpenApiVisitor {
    private static final Logger LOGGER = LogManager.getLogger();
    @Nonnull
    private final List<OpenApiVisitor> visitors = new ArrayList<>();

    public VisitorChain() {}

    public void add(@Nonnull OpenApiVisitor visitor) {
        visitors.add(Objects.requireNonNull(visitor, "visitor cannot be null"));
    }

    private <T extends OpenApiElement<T>> T visit(@Nonnull T element, @Nonnull BiFunction<OpenApiVisitor, T, T> visitMethod) {
        LOGGER.trace("Visiting: {}[{}]", element.getClass().getSimpleName(), element.getPointer());
        var visitorCount = visitors.size();
        for (var i = 0; i < visitorCount; ++i) {
            var newElement = visitMethod.apply(visitors.get(i), element);
            if (newElement != null && newElement != element) {
                element = newElement;
                i = 0;
            }
        }
        return element;
    }

    @Nullable
    @Override
    public OpenApiSpecification visitSpecificationStart(@Nonnull OpenApiSpecification specification) {
        return visit(specification, OpenApiVisitor::visitSpecificationStart);
    }

    @Nullable
    @Override
    public OpenApiSpecification visitSpecificationEnd(@Nonnull OpenApiSpecification specification) {
        return visit(specification, OpenApiVisitor::visitSpecificationEnd);
    }

    @Nullable
    @Override
    public OpenApiPath visitPathStart(@Nonnull OpenApiPath path) {
        return visit(path, OpenApiVisitor::visitPathStart);
    }

    @Nullable
    @Override
    public OpenApiPath visitPathEnd(@Nonnull OpenApiPath path) {
        return visit(path, OpenApiVisitor::visitPathEnd);
    }

    @Nullable
    @Override
    public OpenApiComponents visitComponentsStart(@Nonnull OpenApiComponents components) {
        return visit(components, OpenApiVisitor::visitComponentsStart);
    }

    @Nullable
    @Override
    public OpenApiComponents visitComponentsEnd(@Nonnull OpenApiComponents components) {
        return visit(components, OpenApiVisitor::visitComponentsEnd);
    }

    @Nullable
    @Override
    public OpenApiOperation visitOperationStart(@Nonnull OpenApiOperation operation) {
        return visit(operation, OpenApiVisitor::visitOperationStart);
    }

    @Nullable
    @Override
    public OpenApiOperation visitOperationEnd(@Nonnull OpenApiOperation operation) {
        return visit(operation, OpenApiVisitor::visitOperationEnd);
    }

    @Nullable
    @Override
    public OpenApiParameter visitParameterStart(@Nonnull OpenApiParameter parameter) {
        return visit(parameter, OpenApiVisitor::visitParameterStart);
    }

    @Nullable
    @Override
    public OpenApiParameter visitParameterEnd(@Nonnull OpenApiParameter parameter) {
        return visit(parameter, OpenApiVisitor::visitParameterEnd);
    }

    @Nullable
    @Override
    public OpenApiSchema visitSchemaStart(@Nonnull OpenApiSchema schema) {
        return visit(schema, OpenApiVisitor::visitSchemaStart);
    }

    @Nullable
    @Override
    public OpenApiSchema visitSchemaEnd(@Nonnull OpenApiSchema schema) {
        return visit(schema, OpenApiVisitor::visitSchemaEnd);
    }

    @Nullable
    @Override
    public OpenApiDiscriminator visitDiscriminatorStart(@Nonnull OpenApiDiscriminator discriminator) {
        return visit(discriminator, OpenApiVisitor::visitDiscriminatorStart);
    }

    @Nullable
    @Override
    public OpenApiDiscriminator visitDiscriminatorEnd(@Nonnull OpenApiDiscriminator discriminator) {
        return visit(discriminator, OpenApiVisitor::visitDiscriminatorEnd);
    }

    @Nullable
    @Override
    public OpenApiResponse visitResponseStart(@Nonnull OpenApiResponse response) {
        return visit(response, OpenApiVisitor::visitResponseStart);
    }

    @Nullable
    @Override
    public OpenApiResponse visitResponseEnd(@Nonnull OpenApiResponse response) {
        return visit(response, OpenApiVisitor::visitResponseEnd);
    }

    @Nullable
    @Override
    public OpenApiRequestBody visitRequestBodyStart(@Nonnull OpenApiRequestBody requestBody) {
        return visit(requestBody, OpenApiVisitor::visitRequestBodyStart);
    }

    @Nullable
    @Override
    public OpenApiRequestBody visitRequestBodyEnd(@Nonnull OpenApiRequestBody requestBody) {
        return visit(requestBody, OpenApiVisitor::visitRequestBodyEnd);
    }

    @Nullable
    @Override
    public OpenApiResponses visitResponsesStart(@Nonnull OpenApiResponses responses) {
        return visit(responses, OpenApiVisitor::visitResponsesStart);
    }

    @Nullable
    @Override
    public OpenApiResponses visitResponsesEnd(@Nonnull OpenApiResponses responses) {
        return visit(responses, OpenApiVisitor::visitResponsesEnd);
    }

    @Nullable
    @Override
    public OpenApiContent visitContentStart(@Nonnull OpenApiContent content) {
        return visit(content, OpenApiVisitor::visitContentStart);
    }

    @Nullable
    @Override
    public OpenApiContent visitContentEnd(@Nonnull OpenApiContent content) {
        return visit(content, OpenApiVisitor::visitContentEnd);
    }

    @Nullable
    @Override
    public OpenApiMediaType visitMediaTypeStart(@Nonnull OpenApiMediaType schema) {
        return visit(schema, OpenApiVisitor::visitMediaTypeStart);
    }

    @Nullable
    @Override
    public OpenApiMediaType visitMediaTypeEnd(@Nonnull OpenApiMediaType schema) {
        return visit(schema, OpenApiVisitor::visitMediaTypeEnd);
    }
}
