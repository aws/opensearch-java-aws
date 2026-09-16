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

package org.opensearch.client.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        var mainClass = System.getProperty("samples.mainClass");
        if (mainClass == null || mainClass.isEmpty()) {
            LOGGER.error("Please specify the main class to run with -Dsamples.mainClass=<main class>");
            System.exit(1);
        }

        if (!mainClass.startsWith("org.")) {
            mainClass = Main.class.getPackageName() + "." + mainClass;
        }

        LOGGER.info("Running main class: {}", mainClass);

        try {
            final var clazz = Class.forName(mainClass);
            final var mainMethod = clazz.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) args);
        } catch (Exception e) {
            LOGGER.error("Failed to run main class", e);
            System.exit(1);
        }
    }
}
