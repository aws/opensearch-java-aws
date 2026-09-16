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

import com.samskivert.mustache.Mustache;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nullable;
import software.amazon.awssdk.opensearch.client.codegen.model.Shape;
import software.amazon.awssdk.opensearch.client.codegen.renderer.lambdas.TypeIsDefinedLambda;
import software.amazon.awssdk.opensearch.client.codegen.renderer.lambdas.TypeQueryParamifyLambda;
import software.amazon.awssdk.opensearch.client.codegen.renderer.lambdas.TypeSerializerLambda;

public abstract class TypeRef {
    public abstract String getName();

    public abstract boolean hasTypeParams();

    @Nullable
    public abstract TypeRef[] getTypeParams();

    public abstract boolean isTypeParameterRef();

    public abstract boolean canQueryParamify();

    public abstract boolean hasBuilder();

    public abstract TypeRef getBuilderType();

    public abstract TypeRef getBuilderFnType();

    public abstract boolean isInsidePackage(String packageName);

    public abstract boolean isList();

    public abstract TypeRef getListValueType();

    public abstract boolean isMap();

    public abstract TypeRef getMapEntryType();

    public abstract TypeRef getMapKeyType();

    public abstract TypeRef getMapValueType();

    public final boolean isListOrMap() {
        return isList() || isMap();
    }

    public abstract boolean isString();

    public abstract boolean isEnum();

    public abstract boolean isPotentiallyBoxedPrimitive();

    public abstract Optional<Shape> getTargetShape();

    public abstract TypeRef getBoxed();

    public abstract String toString();

    public abstract void getRequiredImports(Set<String> imports, String currentPkg);

    public abstract Type getNestedType(String name);

    public TypeRef getSelfType() {
        return this;
    }

    public final Mustache.Lambda serializer() {
        return new TypeSerializerLambda(this, false);
    }

    public final Mustache.Lambda directSerializer() {
        return new TypeSerializerLambda(this, true);
    }

    public Mustache.Lambda queryParamify() {
        return new TypeQueryParamifyLambda(this);
    }

    public Mustache.Lambda isDefined() {
        return new TypeIsDefinedLambda(this);
    }
}
