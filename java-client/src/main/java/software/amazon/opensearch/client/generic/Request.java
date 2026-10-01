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
package software.amazon.opensearch.client.generic;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Generic HTTP request to OpenSearch
 */
public interface Request {

    /**
     * The HTTP method.
     */
    String getMethod();

    /**
     * The path of the request (without scheme, host, port, or prefix).
     * @return path of the request
     */
    String getEndpoint();

    /**
     * Query string parameters. The returned map is an unmodifiable view of the
     * map in the request.
     * @return query string parameters
     */
    Map<String, String> getParameters();

    /**
     * List of headers
     * @return list of headers
     */
    Collection<Map.Entry<String, String>> getHeaders();

    /**
     * The optional body of the request. If {@code Optional.empty()} then no body
     * is sent with the request.
     * @return optional body of the request
     */
    Optional<Body> getBody();

}
