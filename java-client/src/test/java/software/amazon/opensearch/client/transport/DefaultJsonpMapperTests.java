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
package software.amazon.opensearch.client.transport;

import static software.amazon.opensearch.client.transport.JsonpMapperTestSupport.assertApacheExchanges;
import static software.amazon.opensearch.client.transport.JsonpMapperTestSupport.assertAwsExchanges;

import org.junit.Test;

public class DefaultJsonpMapperTests {
    @Test
    public void awsDefaultMapperDeserializesSearchDocuments() throws Exception {
        assertAwsExchanges(false, null);
    }

    @Test
    public void awsDefaultMapperSerializesIndexedDocuments() throws Exception {
        assertAwsExchanges(true, null);
    }

    @Test
    public void apacheDefaultMapperDeserializesSearchDocuments() throws Exception {
        assertApacheExchanges(false, null);
    }

    @Test
    public void apacheDefaultMapperSerializesIndexedDocuments() throws Exception {
        assertApacheExchanges(true, null);
    }

}
