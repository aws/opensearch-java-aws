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
package software.amazon.awssdk.opensearch.client.transport.aws;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * A reactive subscriber that captures a byte stream into a byte array
 */
class AsyncCapturingSubscriber implements Subscriber<ByteBuffer> {
    private final ByteArrayOutputStream buffer;
    private final CompletableFuture<byte[]> promise;
    private Subscription subscription;

    AsyncCapturingSubscriber() {
        buffer = new ByteArrayOutputStream();
        promise = new CompletableFuture<>();
    }

    public CompletableFuture<byte[]> getPromise() {
        return promise;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(ByteBuffer buf) {
        try {
            if (buf != null && buf.remaining() > 0) {
                if (buf.hasArray()) {
                    buffer.write(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining());
                } else {
                    byte[] data = new byte[buf.remaining()];
                    buf.asReadOnlyBuffer().get(data);
                    buffer.write(data);
                }
            }
            this.subscription.request(1);
        } catch (Throwable e) {
            promise.completeExceptionally(e);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e == null) {
            e = new IllegalArgumentException("Subscriber.onError called with null paramter");
        }
        promise.completeExceptionally(e);
    }

    @Override
    public void onComplete() {
        promise.complete(buffer.toByteArray());
    }
}
