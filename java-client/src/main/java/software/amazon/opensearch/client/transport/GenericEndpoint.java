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

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import software.amazon.opensearch.client.json.JsonpDeserializer;

/**
 * An endpoint with a raw, unparsed response body. The endpoind does not distinguish between errornous and successful response
 * and always return the raw response body.
 */
public interface GenericEndpoint<RequestT, ResponseT> extends Endpoint<RequestT, ResponseT, ResponseT> {
    default public boolean isError(int statusCode) {
        return false; /* never return an error since errorDeserializer is JSON specific */
    }

    /**
     * The error is never deserialized explicitly, represented as the instance of {@link ResponseT} instead.
     */
    default public JsonpDeserializer<ResponseT> errorDeserializer(int statusCode) {
        return null;
    }

    /**
     * Constructs the {@link ResponseT} instance
     * @param uri request URI
     * @param method HTTP method
     * @param protocol HTTP protocol version
     * @param status status code
     * @param reason reason phrase
     * @param headers response headers
     * @param body optional body
     * @return the {@link ResponseT} instance
     */
    ResponseT responseDeserializer(
        final String uri,
        final String method,
        final String protocol,
        int status,
        final String reason,
        final List<Map.Entry<String, String>> headers,
        @Nullable final String contentType,
        @Nullable final InputStream body
    );
}
