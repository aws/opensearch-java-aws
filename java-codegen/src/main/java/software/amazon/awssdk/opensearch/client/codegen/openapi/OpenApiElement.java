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

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import software.amazon.awssdk.opensearch.client.codegen.utils.Clone;
import software.amazon.awssdk.opensearch.client.codegen.utils.Lists;
import software.amazon.awssdk.opensearch.client.codegen.utils.Maps;
import software.amazon.awssdk.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import software.amazon.awssdk.opensearch.client.codegen.utils.json.JsonGenerator;
import software.amazon.awssdk.opensearch.client.codegen.utils.json.ToJson;

public abstract class OpenApiElement<Self extends OpenApiElement<Self>> implements Clone<Self>, ToJson {
    @Nullable
    private OpenApiSpecification specification;
    @Nonnull
    private JsonPointer pointer = JsonPointer.ROOT;

    OpenApiElement(@Nonnull AbstractBuilder<Self, ?> builder) {}

    OpenApiElement() {}

    @Nonnull
    @SuppressWarnings("unchecked")
    Self self() {
        return (Self) this;
    }

    @Override
    public abstract Self clone();

    Optional<OpenApiSpecification> getSpecification() {
        return Optional.ofNullable(specification);
    }

    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        this.pointer = Objects.requireNonNull(pointer, "pointer must not be null");

        OpenApiSpecification newSpec = null;
        if (parent != null) {
            newSpec = parent.getSpecification().orElse(null);
        }
        if (newSpec != specification && specification != null) {
            specification.removeElement(this);
        }
        specification = newSpec;
        if (specification != null) {
            specification.registerElement(this);
        }
    }

    final void initializeChild(@Nonnull String subKey, @Nullable OpenApiElement<?> child) {
        if (child == null) {
            return;
        }
        Objects.requireNonNull(subKey, "subKey must not be null");
        child.initialize(this, getPointer().append(subKey));
    }

    final void initializeChildren(@Nonnull String subKey, @Nullable List<? extends OpenApiElement<?>> children) {
        if (children == null) {
            return;
        }
        Objects.requireNonNull(subKey, "subKey must not be null");
        var ptr = getPointer().append(subKey);
        Lists.forEach(children, (i, v) -> v.initialize(this, ptr.append(String.valueOf(i))));
    }

    final void initializeChildren(@Nonnull String subKey, @Nullable Map<?, ? extends OpenApiElement<?>> children) {
        if (children == null) {
            return;
        }
        Objects.requireNonNull(subKey, "subKey must not be null");
        var ptr = getPointer().append(subKey);
        children.forEach((k, v) -> v.initialize(this, ptr.append(k.toString())));
    }

    @Nonnull
    public JsonPointer getPointer() {
        return pointer;
    }

    @Nullable
    <TIn, TOut> List<TOut> children(@Nullable List<TIn> children, @Nonnull Factory<TIn, TOut> factory) {
        if (children == null) {
            return null;
        }
        Objects.requireNonNull(factory, "factory must not be null");
        return Lists.map(children, (i, v) -> factory.create(v));
    }

    @Nullable
    <TKey, TInValue, TOutValue> Map<TKey, TOutValue> children(
        @Nullable Map<TKey, TInValue> children,
        @Nonnull Factory<TInValue, TOutValue> valueFactory
    ) {
        return children(children, Function.identity(), valueFactory);
    }

    @Nullable
    <TInKey, TOutKey, TInValue, TOutValue> Map<TOutKey, TOutValue> children(
        @Nullable Map<TInKey, TInValue> children,
        @Nonnull Function<TInKey, TOutKey> keyMapper,
        @Nonnull Factory<TInValue, TOutValue> valueFactory
    ) {
        if (children == null) {
            return null;
        }
        Objects.requireNonNull(keyMapper, "keyMapper must not be null");
        Objects.requireNonNull(valueFactory, "valueFactory must not be null");
        return Maps.transform(children, (k, v) -> keyMapper.apply(k), (k, v) -> valueFactory.create(v));
    }

    @Override
    public void toJson(JsonGenerator generator) {
        generator.writeObject(this::toJsonInner);
    }

    protected abstract void toJsonInner(JsonGenerator generator);

    interface Factory<TIn, TOut> {
        @Nonnull
        TOut create(@Nonnull TIn value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pointer", pointer).toString();
    }

    @Nonnull
    <Builder extends AbstractBuilder<Self, Builder>> Builder toBuilder(@Nonnull Builder builder) {
        return Objects.requireNonNull(builder, "builder must not be null");
    }

    public static abstract class AbstractBuilder<Element extends OpenApiElement<Element>, Builder extends AbstractBuilder<Element, Builder>>
        extends ObjectBuilderBase<Element, Builder> {

        AbstractBuilder() {}
    }
}
