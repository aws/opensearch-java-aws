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
package software.amazon.opensearch.client.codegen.transformer.overrides;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSchema;

public class OverridesTests {
    @ParameterizedTest
    @CsvSource({
        "_common___NodeAttributes,attributes",
        "_common___NodeAttributes,transport_address",
        "indices.segments___Segment,attributes",
        "indices.segments___Segment,compound",
        "indices.segments___Segment,version" })
    public void aosMakesConditionalResponseFieldsOptional(String schema, String property) {
        assertEquals(Optional.of(false), required(Overrides.forDistribution("aos"), schema, property));
        assertEquals(Optional.empty(), required(Overrides.forDistribution("aoss"), schema, property));
    }

    @ParameterizedTest
    @CsvSource({ "aoss", "oss" })
    public void otherDistributionsUseSharedOverrides(String distribution) {
        assertSame(Overrides.OVERRIDES, Overrides.forDistribution(distribution));
    }

    private static Optional<Boolean> required(Overrides overrides, String schema, String property) {
        return overrides.getSchema(OpenApiSchema.COMPONENTS_SCHEMAS.append(schema))
            .map(so -> so.getProperty(property))
            .flatMap(PropertyOverride::getRequired);
    }
}
