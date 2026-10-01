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

public class ArrayShape extends ObjectShape {
    private final Field valueBodyField;

    public ArrayShape(
        Namespace parent,
        String className,
        TypeRef arrayType,
        String typedefName,
        String description,
        ShouldGenerate shouldGenerate
    ) {
        super(parent, className, typedefName, description, shouldGenerate);
        this.valueBodyField = Field.builder()
            .withName("valueBody")
            .withType(arrayType)
            .withRequired(true)
            .withDescription("Response value.")
            .build();
        tryAddReference(ReferenceKind.Field, arrayType);
    }

    @Override
    public Collection<Field> getFields() {
        return List.of(valueBodyField);
    }

    @Override
    public Collection<TypeRef> getAnnotations() {
        return List.of(Types.Client.Json.JsonpDeserializable);
    }

    public Field getValueBodyField() {
        return valueBodyField;
    }

    @Override
    public boolean canBeSingleton() {
        return false;
    }
}
