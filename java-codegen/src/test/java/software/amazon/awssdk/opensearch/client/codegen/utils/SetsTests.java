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

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SetsTests {
    @Test
    public void unmodifiableOpt_withNullSet_shouldReturnEmptyOptional() {
        assertTrue(Sets.unmodifiableOpt(null).isEmpty());
    }

    @Test
    public void unmodifiableOpt_withNonNullSet_shouldReturnUnmodifiableSet() {
        var opt = Sets.unmodifiableOpt(new HashSet<>(List.of("foobar")));
        assertTrue(opt.isPresent());
        var set = opt.get();
        assertEquals(1, set.size());
        assertEquals("foobar", set.iterator().next());
        assertEquals("java.util.Collections$UnmodifiableSet", set.getClass().getName());
        assertThrowsExactly(UnsupportedOperationException.class, () -> set.add("hello world"));
    }
}
