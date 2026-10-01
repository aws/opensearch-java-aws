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
package software.amazon.opensearch.client.codegen;

import java.util.Objects;
import java.util.regex.Pattern;

public final class CodegenSettings {
    public static final String DEFAULT_RUNTIME_PACKAGE = "org.opensearch.client";
    public static final String DEFAULT_MODEL_PACKAGE = DEFAULT_RUNTIME_PACKAGE + ".opensearch";
    public static final String DEFAULT_ROOT_CLIENT_NAME = "OpenSearch";
    public static final String DEFAULT_DISTRIBUTION = "oss";

    private static final String RUNTIME_PACKAGE_PROPERTY = "opensearch.codegen.runtimePackage";
    private static final String MODEL_PACKAGE_PROPERTY = "opensearch.codegen.modelPackage";

    private static final Pattern JAVA_PACKAGE = Pattern.compile(
        "[\\p{javaJavaIdentifierStart}][\\p{javaJavaIdentifierPart}]*(\\.[\\p{javaJavaIdentifierStart}][\\p{javaJavaIdentifierPart}]*)*"
    );
    private static final Pattern JAVA_TYPE_PREFIX = Pattern.compile("[\\p{javaJavaIdentifierStart}][\\p{javaJavaIdentifierPart}]*");

    private CodegenSettings() {}

    public static void configureTypePackages(String runtimePackage, String modelPackage) {
        System.setProperty(RUNTIME_PACKAGE_PROPERTY, requireJavaPackage(runtimePackage, "runtime package"));
        System.setProperty(MODEL_PACKAGE_PROPERTY, requireJavaPackage(modelPackage, "model package"));
    }

    public static String runtimePackage() {
        return System.getProperty(RUNTIME_PACKAGE_PROPERTY, DEFAULT_RUNTIME_PACKAGE);
    }

    public static String modelPackage() {
        return System.getProperty(MODEL_PACKAGE_PROPERTY, DEFAULT_MODEL_PACKAGE);
    }

    public static String requireJavaPackage(String value, String description) {
        Objects.requireNonNull(value, description + " must not be null");
        if (!JAVA_PACKAGE.matcher(value).matches()) {
            throw new IllegalArgumentException(description + " is not a valid Java package: " + value);
        }
        return value;
    }

    public static String requireJavaTypePrefix(String value, String description) {
        Objects.requireNonNull(value, description + " must not be null");
        if (!JAVA_TYPE_PREFIX.matcher(value).matches()) {
            throw new IllegalArgumentException(description + " is not a valid Java type prefix: " + value);
        }
        return value;
    }
}
