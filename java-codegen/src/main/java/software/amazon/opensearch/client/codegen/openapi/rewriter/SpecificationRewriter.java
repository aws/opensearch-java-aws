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
import java.util.Set;
import java.util.function.BiFunction;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.semver4j.Semver;
import software.amazon.opensearch.client.codegen.openapi.JsonPointer;
import software.amazon.opensearch.client.codegen.openapi.OpenApiComponents;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSchema;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSpecification;
import software.amazon.opensearch.client.codegen.openapi.reference.RelativeRef;
import software.amazon.opensearch.client.codegen.openapi.walker.OpenApiVisitor;
import software.amazon.opensearch.client.codegen.openapi.walker.OpenApiWalker;
import software.amazon.opensearch.client.codegen.transformer.overrides.Overrides;
import software.amazon.opensearch.client.codegen.utils.Maps;

public final class SpecificationRewriter {
    private static final int MAX_GENERIC_LABELING_PASSES = 10;

    @Nonnull
    public static OpenApiSpecification rewrite(@Nonnull OpenApiSpecification specification, @Nonnull Overrides overrides) {
        return rewrite(specification, overrides, null);
    }

    @Nonnull
    public static OpenApiSpecification rewrite(
        @Nonnull OpenApiSpecification specification,
        @Nonnull Overrides overrides,
        @Nullable Semver maxVersion
    ) {
        var visitorChain = new ArrayList<BiFunction<OpenApiWalker, OpenApiSpecification, OpenApiVisitor>>();

        visitorChain.add((w, s) -> new ExtendsAllOfRewritingVisitor());
        visitorChain.add((w, s) -> new OneOfAllExtendsInvertingVisitor());
        visitorChain.add((w, s) -> new TypeDeterminingVisitor(w));
        visitorChain.add((w, s) -> new ObjectFlatteningVisitor(overrides, w, maxVersion, collectConcreteReferences(s)));
        visitorChain.add((w, s) -> new ResponseSchemaVisitor());

        for (var visitorFactory : visitorChain) {
            var walker = new OpenApiWalker();
            var visitor = visitorFactory.apply(walker, specification);
            specification = walker.walkSpecification(specification, visitor);
        }

        // A schema inside a reference cycle sees the flags of a schema still being visited, so repeat until nothing changes.
        for (var pass = 0; pass < MAX_GENERIC_LABELING_PASSES; ++pass) {
            var walker = new OpenApiWalker();
            var visitor = new GenericLabelingVisitor(walker);
            specification = walker.walkSpecification(specification, visitor);
            if (!visitor.hasChanged()) {
                break;
            }
            if (pass == MAX_GENERIC_LABELING_PASSES - 1) {
                throw new IllegalStateException("Generic labeling did not converge");
            }
        }

        patchSpecification(specification);

        return specification;
    }

    private static Set<JsonPointer> collectConcreteReferences(OpenApiSpecification specification) {
        var visitor = new ConcreteReferenceCollectingVisitor();
        new OpenApiWalker().walkSpecification(specification, visitor);
        return visitor.getReferenced();
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
