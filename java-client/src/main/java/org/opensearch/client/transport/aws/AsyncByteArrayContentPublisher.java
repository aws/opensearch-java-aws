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
package org.opensearch.client.transport.aws;

import java.nio.ByteBuffer;
import java.util.Optional;
import javax.annotation.CheckForNull;
import org.reactivestreams.Subscriber;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.http.async.SdkHttpContentPublisher;

/**
 * An implementation of AWS {@SdkHttpContentPublisher} that transfers a pre-existing
 * byte array
 */
class AsyncByteArrayContentPublisher implements SdkHttpContentPublisher {
    private final AsyncRequestBody delegate;

    AsyncByteArrayContentPublisher(@CheckForNull byte[] data) {
        if (data == null) {
            delegate = AsyncRequestBody.empty();
        } else {
            delegate = AsyncRequestBody.fromBytes(data);
        }
    }

    @Override
    public Optional<Long> contentLength() {
        return delegate.contentLength();
    }

    @Override
    public void subscribe(Subscriber<? super ByteBuffer> s) {
        delegate.subscribe(s);
    }
}
