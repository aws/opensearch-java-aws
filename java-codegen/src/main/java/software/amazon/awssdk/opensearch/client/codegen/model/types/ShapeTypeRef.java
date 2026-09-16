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
package software.amazon.awssdk.opensearch.client.codegen.model.types;

import java.util.Optional;
import java.util.Set;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import software.amazon.awssdk.opensearch.client.codegen.model.EnumShape;
import software.amazon.awssdk.opensearch.client.codegen.model.Shape;

public class ShapeTypeRef extends TypeRef {
    private final Shape shape;

    public ShapeTypeRef(Shape shape) {
        this.shape = shape;
    }

    @Override
    public String getName() {
        return shape.getClassName();
    }

    @Override
    public boolean hasTypeParams() {
        return shape.getMaterializedType().hasTypeParams();
    }

    @Nullable
    @Override
    public TypeRef[] getTypeParams() {
        return shape.getMaterializedType().getTypeParams();
    }

    @Override
    public boolean isTypeParameterRef() {
        return false;
    }

    @Override
    public boolean canQueryParamify() {
        return isEnum();
    }

    @Override
    public boolean hasBuilder() {
        return !isEnum();
    }

    @Override
    public Type getBuilderType() {
        if (!hasBuilder()) return null;

        return shape.getMaterializedType().getBuilderType();
    }

    @Override
    public Type getBuilderFnType() {
        if (!hasBuilder()) return null;

        return Types.Java.Util.Function.Function(getBuilderType(), Types.Client.Util.ObjectBuilder(this));
    }

    @Override
    public boolean isInsidePackage(String packageName) {
        return shape.getPackageName().startsWith(packageName);
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
        return shape instanceof EnumShape;
    }

    @Override
    public boolean isPotentiallyBoxedPrimitive() {
        return false;
    }

    @Override
    public Optional<Shape> getTargetShape() {
        return Optional.of(shape);
    }

    @Override
    public TypeRef getBoxed() {
        return this;
    }

    @Override
    public String toString() {
        return shape.getMaterializedType().toString();
    }

    @Override
    public void getRequiredImports(Set<String> imports, String currentPkg) {
        shape.getMaterializedType().getRequiredImports(imports, currentPkg);
    }

    @Override
    public Type getNestedType(String name) {
        return shape.getMaterializedType().getNestedType(name);
    }

    @Override
    public TypeRef getSelfType() {
        return shape.getSelfType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShapeTypeRef that = (ShapeTypeRef) o;

        return new EqualsBuilder().append(shape, that.shape).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(shape).toHashCode();
    }
}
