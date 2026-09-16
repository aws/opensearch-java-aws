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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.http.async.SdkAsyncHttpResponseHandler;

/**
 * An implementation of AWS {@link SdkAsyncHttpResponseHandler} that captures the response,
 * and the content as a byte array.
 */
final class AsyncCapturingResponseHandler implements SdkAsyncHttpResponseHandler {
    private final CompletableFuture<SdkHttpResponse> responseFuture;
    private final AsyncCapturingSubscriber bodySubscriber = new AsyncCapturingSubscriber();
    private final AtomicBoolean subscribed = new AtomicBoolean(false);

    AsyncCapturingResponseHandler() {
        responseFuture = new CompletableFuture<>();
    }

    public CompletableFuture<SdkHttpResponse> getHeaderPromise() {
        return responseFuture;
    }

    public CompletableFuture<byte[]> getBodyPromise() {
        return bodySubscriber.getPromise();
    }

    @Override
    public void onHeaders(SdkHttpResponse response) {
        responseFuture.complete(response);
    }

    @Override
    public void onStream(Publisher<ByteBuffer> publisher) {
        if (!subscribed.getAndSet(true)) {
            publisher.subscribe(bodySubscriber);
        }
    }

    @Override
    public void onError(Throwable e) {
        responseFuture.completeExceptionally(e);
    }
}
