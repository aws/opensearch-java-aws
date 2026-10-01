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
package software.amazon.opensearch.client.codegen.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.codegen.model.types.TypeRef;
import software.amazon.opensearch.client.codegen.utils.Markdown;
import software.amazon.opensearch.client.codegen.utils.NameSanitizer;
import software.amazon.opensearch.client.codegen.utils.Strings;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectBuilder;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import software.amazon.opensearch.client.codegen.utils.builder.SetBuilder;

public class Field {
    @Nullable
    private final String wireName;
    @Nonnull
    private final String name;
    @Nonnull
    private final TypeRef type;
    private final boolean required;
    @Nullable
    private final String description;
    @Nullable
    private final Deprecation deprecation;
    @Nullable
    private final Set<String> aliases;

    private Field(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");
        if (builder.wireName != null) {
            this.wireName = Strings.requireNonBlank(builder.wireName, "wireName must not be blank");
            this.name = builder.name != null
                ? Strings.requireNonBlank(builder.name, "name must not be blank")
                : NameSanitizer.fieldName(wireName);
        } else {
            this.wireName = null;
            var name = Strings.requireNonBlank(builder.name, "name must not be blank");
            this.name = builder.verbatimName ? name : NameSanitizer.fieldName(name);
        }
        this.type = Objects.requireNonNull(builder.type, "type must not be null");
        this.required = builder.required;
        this.description = builder.description;
        this.deprecation = builder.deprecation;
        this.aliases = builder.aliases;
    }

    @Nullable
    public String getWireName() {
        return wireName;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public TypeRef getType() {
        return required ? type : type.getBoxed();
    }

    public boolean isRequired() {
        return required;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public Deprecation getDeprecation() {
        return deprecation;
    }

    @Nonnull
    public Set<String> getAliases() {
        return aliases != null ? Collections.unmodifiableSet(aliases) : Collections.emptySet();
    }

    public boolean needsJavaDocSummary() {
        return required || description != null || wireName != null;
    }

    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<Field, Builder> {
        private String wireName;
        private String name;
        private boolean verbatimName;
        private TypeRef type;
        private boolean required;
        private String description;
        private Deprecation deprecation;
        private Set<String> aliases;

        private Builder() {}

        private Builder(Field f) {
            this.wireName = f.wireName;
            this.name = f.name;
            this.type = f.type;
            this.required = f.required;
            this.description = f.description;
            this.deprecation = f.deprecation;
            this.aliases = f.aliases != null ? new HashSet<>(f.aliases) : null;
        }

        @Nonnull
        @Override
        protected Field construct() {
            return new Field(this);
        }

        @Nonnull
        public Builder withWireName(@Nullable String wireName) {
            this.wireName = wireName;
            return this;
        }

        @Nonnull
        public Builder withName(@Nullable String name) {
            this.name = name;
            this.verbatimName = false;
            return this;
        }

        @Nonnull
        public Builder withName(@Nullable String name, boolean verbatimName) {
            this.name = name;
            this.verbatimName = verbatimName;
            return this;
        }

        @Nonnull
        public Builder withType(@Nullable TypeRef type) {
            this.type = type;
            return this;
        }

        @Nonnull
        public Builder withRequired(boolean required) {
            this.required = required;
            return this;
        }

        @Nonnull
        public Builder withDescription(@Nullable String description) {
            this.description = description != null ? Markdown.toJavaDocHtml(description) : null;
            return this;
        }

        @Nonnull
        public Builder withDeprecation(@Nullable Deprecation deprecation) {
            this.deprecation = deprecation;
            return this;
        }

        @Nonnull
        public Builder withAliases(@Nonnull Function<SetBuilder<String>, ObjectBuilder<Set<String>>> fn) {
            this.aliases = Objects.requireNonNull(fn, "fn must not be null").apply(new SetBuilder<>()).build();
            return this;
        }
    }
}
