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
import java.util.function.Function;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.codegen.openapi.OpenApiComponents;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSpecification;
import software.amazon.opensearch.client.codegen.openapi.reference.RelativeRef;
import software.amazon.opensearch.client.codegen.openapi.walker.OpenApiVisitor;
import software.amazon.opensearch.client.codegen.openapi.walker.OpenApiWalker;
import software.amazon.opensearch.client.codegen.transformer.overrides.Overrides;
import software.amazon.opensearch.client.codegen.utils.Maps;

public final class SpecificationRewriter {
    @Nonnull
    public static OpenApiSpecification rewrite(@Nonnull OpenApiSpecification specification, @Nonnull Overrides overrides) {
        var visitorChain = new ArrayList<Function<OpenApiWalker, OpenApiVisitor>>();

        visitorChain.add(w -> new ExtendsAllOfRewritingVisitor());
        visitorChain.add(w -> new OneOfAllExtendsInvertingVisitor());
        visitorChain.add(TypeDeterminingVisitor::new);
        visitorChain.add(w -> new ObjectFlatteningVisitor(overrides, w));
        visitorChain.add(w -> new ResponseSchemaVisitor());
        visitorChain.add(GenericLabelingVisitor::new);

        for (var visitorFactory : visitorChain) {
            var walker = new OpenApiWalker();
            var visitor = visitorFactory.apply(walker);
            specification = walker.walkSpecification(specification, visitor);
        }

        patchSpecification(specification);

        return specification;
    }

    private static void patchSpecification(OpenApiSpecification specification) {
        OpenApiSchema additionalProperties = OpenApiSchema.builder()
            .withDescription("Nested aggregations.")
            .withTitle("aggregations")
            .with$ref(RelativeRef.parse("#/components/schemas/_common.aggregations___Aggregate"))
            .build();

        // TODO: Workaround difficulty in representing the MultiBucketBase nested aggregations in the upstream OpenAPI specification
        specification.getComponents().flatMap(OpenApiComponents::getSchemas).ifPresent(schemas -> {
            Maps.tryGet(schemas, "_common.aggregations___MultiBucketBase").ifPresent(s -> s.setAdditionalProperties(additionalProperties));
            Maps.tryGet(schemas, "_common.aggregations___SingleBucketAggregateBase")
                .ifPresent(s -> s.setAdditionalProperties(additionalProperties));
        });
    }
}
