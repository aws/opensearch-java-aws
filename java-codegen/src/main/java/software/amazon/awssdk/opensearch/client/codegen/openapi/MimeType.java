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
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.utils.Maps;
import software.amazon.awssdk.opensearch.client.codegen.utils.Strings;

public enum MimeType {
    Sse("text/event-stream"),
    Cbor("application/cbor"),
    Json("application/json"),
    NdJson("application/x-ndjson"),
    Smile("application/smile"),
    TextPlain("text/plain"),
    Yaml("application/yaml");

    private static final Map<String, MimeType> VALUES = Maps.createLookupOf(values(), MimeType::toString);

    private final String mimeType;

    MimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return this.mimeType;
    }

    @Nonnull
    public static MimeType from(@Nonnull String mimeType) {
        var value = VALUES.get(Strings.requireNonBlank(mimeType, "mimeType must not be blank"));
        if (value == null) {
            throw new IllegalArgumentException("Unknown mime type: " + mimeType);
        }
        return value;
    }
}
