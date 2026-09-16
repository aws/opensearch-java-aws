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
package software.amazon.awssdk.opensearch.client.codegen.renderer;

import com.diffplug.spotless.FormatExceptionPolicyStrict;
import com.diffplug.spotless.Formatter;
import com.diffplug.spotless.LineEnding;
import com.diffplug.spotless.Provisioner;
import com.diffplug.spotless.extra.java.EclipseJdtFormatterStep;
import com.diffplug.spotless.generic.EndWithNewlineStep;
import com.diffplug.spotless.generic.TrimTrailingWhitespaceStep;
import com.diffplug.spotless.java.ImportOrderStep;
import com.diffplug.spotless.java.RemoveUnusedImportsStep;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import software.amazon.awssdk.opensearch.client.codegen.exceptions.JavaFormatterException;
import software.amazon.awssdk.opensearch.client.codegen.utils.MavenArtifactResolver;
import software.amazon.awssdk.opensearch.client.codegen.utils.builder.ObjectBuilderBase;

public class JavaCodeFormatter implements AutoCloseable {
    private final Formatter formatter;

    private JavaCodeFormatter(@Nonnull Builder builder) {
        Objects.requireNonNull(builder, "builder must not be null");

        Provisioner provisioner = MavenArtifactResolver.createDefault()::resolve;

        var eclipseFormatter = EclipseJdtFormatterStep.createBuilder(provisioner);
        eclipseFormatter.setPreferences(
            List.of(Objects.requireNonNull(builder.eclipseFormatterConfig, "eclipseFormatterConfig must not be null"))
        );

        var steps = List.of(
            ImportOrderStep.forJava().createFrom(),
            RemoveUnusedImportsStep.create(RemoveUnusedImportsStep.defaultFormatter(), provisioner),
            eclipseFormatter.build(),
            TrimTrailingWhitespaceStep.create(),
            EndWithNewlineStep.create()
        );

        this.formatter = Formatter.builder()
            .name("java")
            .lineEndingsPolicy(LineEnding.UNIX.createPolicy())
            .encoding(StandardCharsets.UTF_8)
            .rootDir(Objects.requireNonNull(builder.rootDir, "rootDir must not be null"))
            .steps(steps)
            .exceptionPolicy(new FormatExceptionPolicyStrict())
            .build();
    }

    public void format(File file) throws JavaFormatterException {
        try {
            formatter.applyTo(file);
        } catch (Throwable e) {
            throw new JavaFormatterException("Failed to format: " + file, e);
        }
    }

    @Override
    public void close() {
        formatter.close();
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<JavaCodeFormatter, Builder> {
        private Path rootDir;
        private File eclipseFormatterConfig;

        private Builder() {}

        @Nonnull
        @Override
        protected JavaCodeFormatter construct() {
            return new JavaCodeFormatter(this);
        }

        @Nonnull
        public Builder withRootDir(@Nonnull Path rootDir) {
            this.rootDir = Objects.requireNonNull(rootDir, "rootDir must not be null");
            return this;
        }

        @Nonnull
        public Builder withEclipseFormatterConfig(@Nonnull File eclipseFormatterConfig) {
            this.eclipseFormatterConfig = Objects.requireNonNull(eclipseFormatterConfig, "eclipseFormatterConfig must not be null");
            return this;
        }
    }
}
