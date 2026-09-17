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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;

/**
 * Generic HTTP request / response body. It is responsibility of the caller to close the body instance
 * explicitly (or through {@link GenericResponse} instance) to release all associated resources.
 */
public interface Body extends AutoCloseable {
    final int DEFAULT_BUFFER_SIZE = 8192;

    /**
     * Constructs the generic response body out of {@link InputStream} with assumed content type
     * @param body response body stream
     * @param contentType content type
     * @return generic response body instance
     */
    static @Nullable Body from(@Nullable final InputStream body, @Nullable final String contentType) {
        if (body == null) {
            return null;
        } else {
            return new software.amazon.awssdk.opensearch.client.generic.GenericInputStreamBody(body, contentType);
        }
    }

    /**
     * Constructs the generic response body out of {@link InputStream} with assumed content type
     * @param body response body stream
     * @param contentType content type
     * @return generic response body instance
     */
    static @Nullable Body from(@Nullable final byte[] body, @Nullable final String contentType) {
        if (body == null) {
            return null;
        } else {
            return new GenericByteArrayBody(body, contentType);
        }
    }

    /**
     * Content type of this body
     * @return content type
     */
    String contentType();

    /**
     * Gets the body as {@link InputStream}
     * @return body as {@link InputStream}
     */
    InputStream body();

    /**
     * Gets the body as {@link String}
     * @return body as {@link String}
     */
    default String bodyAsString() {
        return new String(bodyAsBytes(), StandardCharsets.UTF_8);
    }

    /**
     * Gets the body as {@code byte[]}
     * @return body as {@code byte[]}
     */
    default byte[] bodyAsBytes() {
        try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            try (final InputStream in = body()) {
                final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
                int read;
                while ((read = in.read(buffer, 0, DEFAULT_BUFFER_SIZE)) >= 0) {
                    out.write(buffer, 0, read);
                }
            }

            out.flush();
            return out.toByteArray();
        } catch (final IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    /**
     * Releases all resources associated with this body stream.
     */
    void close() throws IOException;
}
