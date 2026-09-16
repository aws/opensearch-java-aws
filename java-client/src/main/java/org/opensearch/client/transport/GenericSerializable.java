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
package org.opensearch.client.transport;

import java.io.OutputStream;

/**
 * The request that takes care of serializing its body (content) into the {@link OutputStream}
 */
public interface GenericSerializable {
    /**
     * Serializes into the {@link OutputStream} and returns the content type
     * @param out {@link OutputStream} to serialize into
     * @return content type
     */
    String serialize(OutputStream out);
}
