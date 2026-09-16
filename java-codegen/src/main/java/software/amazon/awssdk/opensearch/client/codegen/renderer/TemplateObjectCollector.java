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
package software.amazon.awssdk.opensearch.client.codegen.renderer;

import com.samskivert.mustache.DefaultCollector;
import com.samskivert.mustache.Mustache;
import java.util.Optional;

public class TemplateObjectCollector extends DefaultCollector {
    @Override
    public Mustache.VariableFetcher createFetcher(Object ctx, String name) {
        var fetcher = super.createFetcher(ctx, name);
        if (fetcher == null) {
            return null;
        }
        return (ctx1, name1) -> {
            var value = fetcher.get(ctx1, name1);
            if (value instanceof Optional) {
                return ((Optional<?>) value).orElse(null);
            }
            return value;
        };
    }
}
