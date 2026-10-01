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

import java.util.Collection;
import java.util.List;
import software.amazon.opensearch.client.codegen.model.types.TypeRef;
import software.amazon.opensearch.client.codegen.model.types.Types;
import software.amazon.opensearch.client.codegen.transformer.overrides.ShouldGenerate;

public class DictionaryResponseShape extends Shape {
    private final TypeRef keyType;
    private final TypeRef valueType;

    public DictionaryResponseShape(
        Namespace parent,
        String className,
        String typedefName,
        String description,
        TypeRef keyType,
        TypeRef valueType,
        ShouldGenerate shouldGenerate
    ) {
        super(parent, className, typedefName, description, shouldGenerate);
        this.keyType = keyType;
        this.valueType = valueType;
        setExtendsType(Types.Client.Transport.Endpoints.DictionaryResponse(keyType, valueType));
    }

    @Override
    public Collection<TypeRef> getAnnotations() {
        return List.of(Types.Client.Json.JsonpDeserializable);
    }

    @Override
    public boolean extendsOtherShape() {
        return true;
    }

    public boolean superImplementsJsonSerializable() {
        return true;
    }
}
