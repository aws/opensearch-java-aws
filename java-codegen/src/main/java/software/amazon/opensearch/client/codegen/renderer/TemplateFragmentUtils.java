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
package software.amazon.opensearch.client.codegen.renderer;

import com.samskivert.mustache.Template;
import java.util.Optional;

public final class TemplateFragmentUtils {
    private TemplateFragmentUtils() {}

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> findParentContext(Template.Fragment fragment, Class<T> clazz) {
        var i = 0;
        while (true) {
            Object ctx;

            try {
                ctx = fragment.context(i++);
            } catch (NullPointerException ignored) {
                return Optional.empty();
            }

            if (clazz.isAssignableFrom(ctx.getClass())) {
                return Optional.of((T) ctx);
            }
        }
    }
}
