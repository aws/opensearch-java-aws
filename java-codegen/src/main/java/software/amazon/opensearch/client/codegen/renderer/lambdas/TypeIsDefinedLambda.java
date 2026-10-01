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
package software.amazon.opensearch.client.codegen.renderer.lambdas;

import com.samskivert.mustache.Template;
import java.util.Objects;
import javax.annotation.Nonnull;
import software.amazon.opensearch.client.codegen.model.types.TypeRef;
import software.amazon.opensearch.client.codegen.utils.Strings;

public final class TypeIsDefinedLambda extends TemplateRenderingLambda {
    @Nonnull
    private final TypeRef type;

    public TypeIsDefinedLambda(TypeRef type) {
        super("Type/isDefined");
        this.type = Objects.requireNonNull(type, "type must not be null");
    }

    @Override
    public Object getContext(Template.Fragment fragment) {
        return new Context(type, fragment.execute());
    }

    public static final class Context {
        @Nonnull
        private final TypeRef type;
        @Nonnull
        private final String value;

        private Context(@Nonnull TypeRef type, @Nonnull String value) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            this.value = Strings.requireNonBlank(value, "value must not be blank");
        }

        @Nonnull
        public TypeRef getType() {
            return type;
        }

        @Nonnull
        public String getValue() {
            return value;
        }
    }
}
