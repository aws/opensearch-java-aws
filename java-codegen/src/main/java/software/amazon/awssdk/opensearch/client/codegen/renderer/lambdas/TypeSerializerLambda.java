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
package software.amazon.awssdk.opensearch.client.codegen.renderer.lambdas;

import com.samskivert.mustache.Template;
import java.util.Objects;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.model.types.TypeRef;
import software.amazon.awssdk.opensearch.client.codegen.renderer.TemplateFragmentUtils;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;

public final class TypeSerializerLambda extends TemplateRenderingLambda {
    @Nonnull
    private final TypeRef type;

    public TypeSerializerLambda(TypeRef type, boolean direct) {
        super("Type/" + (direct ? "directSerializer" : "serializer"));
        this.type = Objects.requireNonNull(type, "type must not be null");
    }

    @Override
    public Object getContext(Template.Fragment fragment) {
        var depth = TemplateFragmentUtils.findParentContext(fragment, Context.class).map(ctx -> ctx.depth + 1).orElse(0);
        return new Context(type, fragment.execute(), depth);
    }

    public static final class Context {
        @Nonnull
        private final TypeRef type;
        @Nonnull
        private final String value;
        private final int depth;

        private Context(@Nonnull TypeRef type, @Nonnull String value, int depth) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            this.value = Strings.requireNonBlank(value, "value must not be blank");
            this.depth = depth;
        }

        @Nonnull
        public TypeRef getType() {
            return type;
        }

        @Nonnull
        public String getValue() {
            return value;
        }

        public int getDepth() {
            return depth;
        }
    }
}
