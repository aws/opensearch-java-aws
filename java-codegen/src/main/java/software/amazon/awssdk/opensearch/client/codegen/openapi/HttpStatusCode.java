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
package software.amazon.awssdk.opensearch.client.codegen.openapi;

import java.util.Map;
import software.amazon.awssdk.opensearch.client.codegen.utils.Maps;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;

public enum HttpStatusCode {
    Ok("200"),
    Created("201"),
    Accepted("202"),
    NoContent("204"),
    BadRequest("400"),
    Forbidden("403"),
    NotFound("404"),
    MethodNotAllowed("405"),
    RequestTimeout("408"),
    Conflict("409"),
    InternalServerError("500"),
    NotImplemented("501");

    private static final Map<String, HttpStatusCode> VALUES = Maps.createLookupOf(values(), HttpStatusCode::toString);

    private final String code;

    HttpStatusCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

    public static HttpStatusCode from(String code) {
        var value = VALUES.get(Strings.requireNonBlank(code, "code must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown status code: " + code);
        }
        return value;
    }

    public boolean isSuccessful() {
        return this.code.startsWith("2");
    }
}
