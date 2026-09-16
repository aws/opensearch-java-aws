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
package software.amazon.awssdk.opensearch.client.generic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

/**
 * The HTTP request / response body that uses {@link byte[]}
 */
final class GenericByteArrayBody implements Body {
    private final byte[] bytes;
    private final String contentType;

    GenericByteArrayBody(final byte[] bytes, @Nullable final String contentType) {
        this.bytes = bytes;
        this.contentType = contentType;
    }

    @Override
    public String contentType() {
        return contentType;
    }

    @Override
    public InputStream body() {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void close() throws IOException {}
}
