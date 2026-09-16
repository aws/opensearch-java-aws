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
package software.amazon.awssdk.opensearch.client.json.jackson3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.ObjectWriteContext;

class XObjectWriteContext extends ObjectWriteContext.Base {
    private static final XObjectWriteContext DEFAULT_INSTANCE = new XObjectWriteContext();

    static XObjectWriteContext create() {
        return DEFAULT_INSTANCE;
    }

    private XObjectWriteContext() {}

    @Override
    public void writeValue(JsonGenerator g, Object value) {
        // Bringing the implementation from Jackson 2.x release line (see please
        // https://github.com/FasterXML/jackson-core/blob/2.x/src/main/java/com/fasterxml/jackson/core/JsonGenerator.java#L3099).

        // 31-Dec-2009, tatu: Actually, we could just handle some basic
        // types even without codec. This can improve interoperability,
        // and specifically help with TokenBuffer.
        if (value == null) {
            g.writeNull();
            return;
        }
        if (value instanceof String) {
            g.writeString((String) value);
            return;
        }
        if (value instanceof Number) {
            Number n = (Number) value;
            if (n instanceof Integer) {
                g.writeNumber(n.intValue());
                return;
            } else if (n instanceof Long) {
                g.writeNumber(n.longValue());
                return;
            } else if (n instanceof Double) {
                g.writeNumber(n.doubleValue());
                return;
            } else if (n instanceof Float) {
                g.writeNumber(n.floatValue());
                return;
            } else if (n instanceof Short) {
                g.writeNumber(n.shortValue());
                return;
            } else if (n instanceof Byte) {
                g.writeNumber(n.byteValue());
                return;
            } else if (n instanceof BigInteger) {
                g.writeNumber((BigInteger) n);
                return;
            } else if (n instanceof BigDecimal) {
                g.writeNumber((BigDecimal) n);
                return;
                // then Atomic types
            } else if (n instanceof AtomicInteger) {
                g.writeNumber(((AtomicInteger) n).get());
                return;
            } else if (n instanceof AtomicLong) {
                g.writeNumber(((AtomicLong) n).get());
                return;
            }
        } else if (value instanceof byte[]) {
            g.writeBinary((byte[]) value);
            return;
        } else if (value instanceof Boolean) {
            g.writeBoolean((Boolean) value);
            return;
        } else if (value instanceof AtomicBoolean) {
            g.writeBoolean(((AtomicBoolean) value).get());
            return;
        }
        throw new IllegalStateException(
            "No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed "
                + value.getClass().getName()
                + ")"
        );
    }
}
