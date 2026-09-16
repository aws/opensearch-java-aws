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
package software.amazon.awssdk.opensearch.client.codegen.model;

import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;

public class OperationGroup {
    @Nullable
    private final String namespace;
    @Nonnull
    private final String name;

    @Nonnull
    public static OperationGroup from(@Nonnull String operationGroup) {
        Strings.requireNonBlank(operationGroup, "operationGroup must not be blank");
        int index = operationGroup.lastIndexOf('.');
        if (index == -1) {
            return new OperationGroup(null, operationGroup);
        }
        return new OperationGroup(operationGroup.substring(0, index), operationGroup.substring(index + 1));
    }

    public OperationGroup(@Nullable String namespace, @Nonnull String name) {
        this.namespace = namespace;
        this.name = Strings.requireNonBlank(name, "name must not be blank");
    }

    @Nonnull
    public Optional<String> getNamespace() {
        return Optional.ofNullable(namespace);
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public String asTypedefPrefix() {
        return (namespace == null ? "_global" : namespace) + "." + name;
    }

    @Override
    public String toString() {
        return namespace == null ? name : namespace + "." + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OperationGroup that = (OperationGroup) o;

        return new EqualsBuilder().append(namespace, that.namespace).append(name, that.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(namespace).append(name).toHashCode();
    }
}
