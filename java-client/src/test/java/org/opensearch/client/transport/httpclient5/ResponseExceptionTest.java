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
package org.opensearch.client.transport.httpclient5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.message.RequestLine;
import org.junit.Test;

public class ResponseExceptionTest {

    @Test
    public void testStatus() throws IOException {
        final ResponseException response = this.buildResponseException(HttpStatus.SC_BAD_REQUEST);
        assertThat(response.status(), equalTo(HttpStatus.SC_BAD_REQUEST));
    }

    private ResponseException buildResponseException(final int statusCode) throws IOException {
        return new ResponseException(this.buildTestResponse(statusCode));
    }

    private Response buildTestResponse(final int statusCode) {
        return new Response(
            new RequestLine("GET", "/", HttpVersion.HTTP_1_1),
            new HttpHost("localhost"),
            new BasicClassicHttpResponse(statusCode)
        );
    }

}
