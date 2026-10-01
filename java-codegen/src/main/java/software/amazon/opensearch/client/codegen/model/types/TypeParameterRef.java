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
package software.amazon.opensearch.client.codegen.model.types;

import java.util.Optional;
import java.util.Set;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import software.amazon.opensearch.client.codegen.model.Shape;

public class TypeParameterRef extends TypeRef {
    private final String name;

    public TypeParameterRef(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean hasTypeParams() {
        return false;
    }

    @Nullable
    @Override
    public TypeRef[] getTypeParams() {
        return null;
    }

    @Override
    public boolean isTypeParameterRef() {
        return true;
    }

    @Override
    public boolean canQueryParamify() {
        return false;
    }

    @Override
    public boolean hasBuilder() {
        return false;
    }

    @Override
    public TypeRef getBuilderType() {
        return null;
    }

    @Override
    public TypeRef getBuilderFnType() {
        return null;
    }

    @Override
    public boolean isInsidePackage(String packageName) {
        return false;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public TypeRef getListValueType() {
        return null;
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public TypeRef getMapEntryType() {
        return null;
    }

    @Override
    public TypeRef getMapKeyType() {
        return null;
    }

    @Override
    public TypeRef getMapValueType() {
        return null;
    }

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public boolean isEnum() {
        return false;
    }

    @Override
    public boolean isPotentiallyBoxedPrimitive() {
        return false;
    }

    @Override
    public Optional<Shape> getTargetShape() {
        return Optional.empty();
    }

    @Override
    public TypeRef getBoxed() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void getRequiredImports(Set<String> imports, String currentPkg) {

    }

    @Override
    public Type getNestedType(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TypeParameterRef that = (TypeParameterRef) o;

        return new EqualsBuilder().append(name, that.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).toHashCode();
    }
}
