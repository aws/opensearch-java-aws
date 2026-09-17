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
package software.amazon.awssdk.opensearch.client.json;

import jakarta.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;

public interface PlainJsonSerializable extends JsonpSerializable {

    /**
     * A default method which returns string representation for the instances of classes
     * implementing JsonpSerializable interface.<br>
     * Usage : Eg for SearchRequest.class<pre>{@code SearchRequest implements PlainJsonSerializable{..}
     * SearchRequest searchRequest = SearchRequest.of(request -> request...);
     * String searchRequestString = searchRequest.writeValueAsString();}</pre>  <br>
     *
     */
    default String toJsonString() {
        try (StringWriter writer = new StringWriter()) {
            try (JsonGenerator generator = JsonpUtils.DEFAULT_PROVIDER.createGenerator(writer)) {
                serialize(generator, JsonpUtils.DEFAULT_JSONP_MAPPER);
            }
            return writer.toString();
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
