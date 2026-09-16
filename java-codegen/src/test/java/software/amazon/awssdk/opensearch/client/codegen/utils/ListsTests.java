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

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListsTests {
    @Test
    public void unmodifiableOpt_withNullList_shouldReturnEmptyOptional() {
        assertTrue(Lists.unmodifiableOpt(null).isEmpty());
    }

    @Test
    public void unmodifiableOpt_withNonNullList_shouldReturnUnmodifiableList() {
        var opt = Lists.unmodifiableOpt(new ArrayList<String>() {
            {
                add("foobar");
            }
        });
        assertTrue(opt.isPresent());
        var list = opt.get();
        assertEquals(1, list.size());
        assertEquals("foobar", list.get(0));
        assertEquals("java.util.Collections$UnmodifiableRandomAccessList", list.getClass().getName());
        assertThrowsExactly(UnsupportedOperationException.class, () -> list.add("hello world"));
    }

    @Test
    public void map_shouldMapIntoNewList() {
        var input = new ArrayList<>() {
            {
                add("foobar");
                add("hello world");
            }
        };

        var output = Lists.map(input, (i, v) -> i + "-" + v);

        assertEquals(List.of("foobar", "hello world"), input);
        assertEquals(List.of("0-foobar", "1-hello world"), output);
    }
}
