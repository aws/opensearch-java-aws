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
package software.amazon.opensearch.client.codegen.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class StreamsTests {
    @Test
    public void sortedBy() {
        var stream = Stream.of("a", "b", "c", "d", "e");
        var ordering = new HashMap<String, Integer>() {
            {
                put("c", 1);
                put("e", 2);
                put("a", 3);
                put("d", 4);
                put("b", 5);
            }
        };
        var output = Streams.sortedBy(stream, ordering::get).toArray(String[]::new);
        assertArrayEquals(new String[] { "c", "e", "a", "d", "b" }, output);
    }
}
