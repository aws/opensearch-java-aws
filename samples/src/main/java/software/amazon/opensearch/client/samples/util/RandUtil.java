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
package software.amazon.opensearch.client.samples.util;

import java.util.ArrayList;
import java.util.List;

public class RandUtil {
    public static float rand2Sf() {
        return Math.round(Math.random() * 100.0) / 100.0f;
    }

    public static float[] rand2SfArray(int n) {
        var arr = new float[n];
        for (var i = 0; i < n; ++i) {
            arr[i] = rand2Sf();
        }
        return arr;
    }

    public static List<Float> rand2SfList(int n) {
        var arr = new ArrayList<Float>(n);
        for (var i = 0; i < n; ++i) {
            arr.add(rand2Sf());
        }
        return arr;
    }

    public static <T> T choice(T[] arr) {
        return arr[(int) Math.floor(Math.random() * arr.length)];
    }
}
