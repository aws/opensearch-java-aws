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
//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package software.amazon.awssdk.opensearch.client.aos._types;

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link XyLocation} variants.
 * </p>
 * <p>
 * Variants <code>cartesian</code>, <code>coords</code>, <code>text</code> are not available here as they don't have a dedicated class. Use
 * {@link XyLocation}'s builder for these.
 * </p>
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class XyLocationBuilders {
    private XyLocationBuilders() {}

    /**
     * Creates a builder for the {@link XyCartesianCoordinates cartesian} {@code XyLocation} variant.
     */
    public static XyCartesianCoordinates.Builder cartesian() {
        return new XyCartesianCoordinates.Builder();
    }
}
