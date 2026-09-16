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
package org.opensearch.client.json;

import jakarta.json.stream.JsonParser;
import java.io.InputStream;
import java.io.Reader;

/** Base interface to set JSON properties **/

public interface PlainDeserializable<B> {

    B self();

    /** Updates object with newly provided JSON properties
     @param parser the JsonParser parser
     @param mapper the JsonpMapper mapper used to deserialize values
     @return this object
     **/

    default B withJson(JsonParser parser, JsonpMapper mapper) {
        JsonpDeserializer<?> deserializer = JsonpMapperBase.findDeserializer(this.getClass().getEnclosingClass());
        @SuppressWarnings("unchecked")
        ObjectDeserializer<B> objectDeserializer = (ObjectDeserializer<B>) DelegatingDeserializer.unwrap(deserializer);
        assert objectDeserializer != null;
        return objectDeserializer.deserialize(self(), parser, mapper, parser.next());
    }

    /** Updates object with newly provided JSON properties
     @param inputStream the stream to read from
     @return this object
      * **/
    default B withJson(InputStream inputStream) {
        JsonpMapper defaultMapper = JsonpUtils.DEFAULT_JSONP_MAPPER;
        try (JsonParser parser = defaultMapper.jsonProvider().createParser(inputStream)) {
            return withJson(parser, defaultMapper);
        }
    }

    /** Updates object with newly provided JSON properties
     @param reader the stream to read from
     @return this object
      * **/
    default B withJson(Reader reader) {
        JsonpMapper defaultMapper = JsonpUtils.DEFAULT_JSONP_MAPPER;
        try (JsonParser parser = defaultMapper.jsonProvider().createParser(reader)) {
            return withJson(parser, defaultMapper);
        }
    }

}
