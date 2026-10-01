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

import software.amazon.opensearch.client.codegen.utils.matcher.Matcher;

public final class OperationGroupMatcher {
    private OperationGroupMatcher() {}

    public static Matcher<OperationGroup> name(Matcher<String> nameMatcher) {
        return group -> nameMatcher.matches(group.getName());
    }

    public static Matcher<OperationGroup> namespace(Matcher<String> namespaceMatcher) {
        return group -> namespaceMatcher.matches(group.getNamespace().orElse(null));
    }
}
