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
package software.amazon.opensearch.client.util;

import java.util.Optional;

public class PathEncoder {
    private enum Encoding {
        RFC3986_PATH(software.amazon.opensearch.client.util.PercentCodec.RFC3986_PATH),
        HTTP_CLIENT_V4_EQUIV(PercentCodec.RFC3986_PATH),

        RFC3986_UNRESERVED(PercentCodec.RFC3986_UNRESERVED),
        HTTP_CLIENT_V5_EQUIV(PercentCodec.RFC3986_UNRESERVED);

        private final PercentCodec percentCodec;

        Encoding(PercentCodec percentCodec) {
            this.percentCodec = percentCodec;
        }

        static Optional<Encoding> get(String name) {
            try {
                return Optional.of(Encoding.valueOf(name.toUpperCase()));
            } catch (Exception ignored) {
                return Optional.empty();
            }
        }
    }

    private static final String ENCODING_PROPERTY = "org.opensearch.path.encoding";
    private static final Encoding ENCODING_DEFAULT = Encoding.HTTP_CLIENT_V5_EQUIV;

    private static final Encoding ENCODING = Optional.ofNullable(System.getProperty(ENCODING_PROPERTY))
        .flatMap(Encoding::get)
        .orElse(ENCODING_DEFAULT);

    public static String encode(String pathSegment) {
        return ENCODING.percentCodec.encode(pathSegment);
    }

    public static void encode(StringBuilder dest, CharSequence pathSegment) {
        ENCODING.percentCodec.encode(dest, pathSegment);
    }
}
