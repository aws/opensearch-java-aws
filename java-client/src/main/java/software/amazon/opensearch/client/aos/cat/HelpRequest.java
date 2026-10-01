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

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */
package software.amazon.opensearch.client.aos.cat;

import software.amazon.opensearch.client.errors.ErrorResponse;
import software.amazon.opensearch.client.transport.Endpoint;
import software.amazon.opensearch.client.transport.endpoints.SimpleEndpoint;

// typedef: cat.help.Request

/**
 * Returns help for the Cat APIs.
 */

public class HelpRequest extends software.amazon.opensearch.client.aos.cat.CatRequestBase {
    public HelpRequest() {}

    /**
     * Singleton instance for {@link HelpRequest}.
     */
    public static final HelpRequest _INSTANCE = new HelpRequest();

    // ---------------------------------------------------------------------------------------------

    /**
     * Endpoint "{@code cat.help}".
     */
    public static final Endpoint<HelpRequest, HelpResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
        // Request method
        request -> "GET",
        // Request path
        request -> "/_cat",
        SimpleEndpoint.emptyMap(),
        SimpleEndpoint.emptyMap(),
        false,
        HelpResponse._DESERIALIZER
    );
}
