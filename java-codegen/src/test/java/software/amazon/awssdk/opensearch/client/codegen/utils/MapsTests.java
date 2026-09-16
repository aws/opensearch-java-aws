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
package software.amazon.awssdk.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapsTests {
    @Test
    public void unmodifiableOpt_withNullMap_shouldReturnEmptyOptional() {
        assertTrue(Maps.unmodifiableOpt(null).isEmpty());
    }

    @Test
    public void unmodifiableOpt_withNonNullMap_shouldReturnUnmodifiableMap() {
        var opt = Maps.unmodifiableOpt(new HashMap<String, String>() {
            {
                put("foo", "bar");
            }
        });
        assertTrue(opt.isPresent());
        var map = opt.get();
        assertEquals(1, map.size());
        assertEquals("bar", map.get("foo"));
        assertEquals("java.util.Collections$UnmodifiableMap", map.getClass().getName());
        assertThrowsExactly(UnsupportedOperationException.class, () -> map.put("hello", "world"));
    }

    @Test
    public void transform_shouldTransformIntoNewMap() {
        var input = new HashMap<>() {
            {
                put("foo", "bar");
                put("hello", "world");
            }
        };

        var output = Maps.transform(input, (k, v) -> v, (k, v) -> k + "-" + v);

        assertEquals(Map.of("foo", "bar", "hello", "world"), input);
        assertEquals(Map.of("bar", "foo-bar", "world", "hello-world"), output);
    }
}
