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
package org.opensearch.client.transport.aws;

import org.junit.Assert;
import org.junit.Test;

public class AwsSdk2TransportOptionsTestCase extends Assert {
    @Test
    public void testBuilderResponseCompression() throws Exception {
        AwsSdk2TransportOptions options = AwsSdk2TransportOptions.builder()
            .setResponseCompression(true)
            .setRequestCompressionSize(10)
            .build();
        assertEquals(10, options.requestCompressionSize().intValue());
        assertTrue(options.responseCompression());
    }
}
