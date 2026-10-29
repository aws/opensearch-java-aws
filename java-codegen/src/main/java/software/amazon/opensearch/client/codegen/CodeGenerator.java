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

import static software.amazon.opensearch.client.codegen.model.OperationGroupMatcher.name;
import static software.amazon.opensearch.client.codegen.model.OperationGroupMatcher.namespace;
import static software.amazon.opensearch.client.codegen.utils.matcher.Matcher.and;
import static software.amazon.opensearch.client.codegen.utils.matcher.Matcher.is;
import static software.amazon.opensearch.client.codegen.utils.matcher.Matcher.isNull;
import static software.amazon.opensearch.client.codegen.utils.matcher.Matcher.isOneOf;
import static software.amazon.opensearch.client.codegen.utils.matcher.Matcher.not;
import static software.amazon.opensearch.client.codegen.utils.matcher.Matcher.or;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import software.amazon.opensearch.client.codegen.exceptions.RenderException;
import software.amazon.opensearch.client.codegen.model.Namespace;
import software.amazon.opensearch.client.codegen.model.OperationGroup;
import software.amazon.opensearch.client.codegen.openapi.OpenApiSpecification;
import software.amazon.opensearch.client.codegen.openapi.rewriter.SpecificationRewriter;
import software.amazon.opensearch.client.codegen.renderer.ShapeRenderingContext;
import software.amazon.opensearch.client.codegen.transformer.SpecTransformer;
import software.amazon.opensearch.client.codegen.transformer.overrides.Overrides;
import software.amazon.opensearch.client.codegen.utils.matcher.Matcher;

public class CodeGenerator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Matcher<OperationGroup> OPERATION_MATCHER = not(
        // NB: This is wrapped in a `not`, so this acts as an exclusion list. This is due to some operations not being supported in codegen
        // yet (e.g. uses NDJSON) or new APIs needing review.
        or(
            and(
                namespace(isNull()),
                name(isOneOf("bulk", "bulk_stream", "create", "index", "mget", "msearch", "msearch_template", "termvectors", "update"))
            ),
            and(namespace(is("cat")), name(is("help"))),
            and(namespace(is("indices")), name(is("get_field_mapping"))),
            and(
                namespace(is("ml")),
                name(
                    isOneOf(
                        "chunk_model",
                        "execute_algorithm",
                        "predict",
                        "predict_model",
                        "search_agents",
                        "search_connectors",
                        "search_memory",
                        "search_memory_container",
                        "search_agentic_memory",
                        "search_message",
                        "search_model_group",
                        "search_models",
                        "search_tasks",
                        "train",
                        "train_predict"
                    )
                )
            ),
            // TODO: nodes.hot_threads is a plain text response and should be handled differently
            and(namespace(is("nodes")), name(is("hot_threads"))),

            namespace(
                isOneOf(
                    "asynchronous_search",
                    "flow_framework",
                    "insights",
                    "list",
                    "neural",
                    "notifications",
                    "observability",
                    "ppl",
                    "query",
                    "remote_store",
                    "replication",
                    "rollups",
                    "security_analytics",
                    "sm",
                    "sql",
                    "transforms",
                    "wlm"
                )
            )
        )
    );

    public static void main(String[] args) {
        var inputOpt = Option.builder("i")
            .longOpt("input")
            .desc("The URI or path of the OpenAPI specification")
            .argName("INPUT")
            .hasArg()
            .required()
            .build();
        var eclipseConfigOpt = Option.builder()
            .longOpt("eclipse-config")
            .desc("The path of the Eclipse formatting config file")
            .argName("ECLIPSE_CONFIG")
            .hasArg()
            .required()
            .build();
        var outputOpt = Option.builder("o")
            .longOpt("output")
            .desc("The path to the output directory to generate code into")
            .argName("OUTPUT")
            .hasArg()
            .required()
            .build();
        var distributionOpt = Option.builder()
            .longOpt("distribution")
            .desc("The target distribution identifier")
            .argName("DISTRIBUTION")
            .hasArg()
            .build();
        var runtimePackageOpt = Option.builder()
            .longOpt("runtime-package")
            .desc("The Java package containing the shared client runtime")
            .argName("PACKAGE")
            .hasArg()
            .build();
        var modelPackageOpt = Option.builder()
            .longOpt("model-package")
            .desc("The root Java package for generated API clients and models")
            .argName("PACKAGE")
            .hasArg()
            .build();
        var clientNameOpt = Option.builder()
            .longOpt("client-name")
            .desc("The generated root client class prefix, without Client or AsyncClient")
            .argName("NAME")
            .hasArg()
            .build();
        var helpOpt = Option.builder("h").longOpt("help").desc("Print this help information").build();
        final var usageString =
            "CodeGenerator.class --input https://.../opensearch-openapi.yaml --eclipse-config ./buildSrc/formatterConfig.xml "
                + "--output ./java-client/src/generated/java [--distribution aos] "
                + "[--runtime-package software.amazon.opensearch.client] "
                + "[--model-package software.amazon.opensearch.client.aos] [--client-name OpenSearchAos]";

        var options = new Options().addOption(inputOpt)
            .addOption(eclipseConfigOpt)
            .addOption(outputOpt)
            .addOption(distributionOpt)
            .addOption(runtimePackageOpt)
            .addOption(modelPackageOpt)
            .addOption(clientNameOpt)
            .addOption(helpOpt);

        var cliParser = new DefaultParser();

        try {
            var cli = cliParser.parse(options, args);

            if (cli.hasOption(helpOpt)) {
                var helpFormatter = HelpFormatter.builder().get();
                helpFormatter.printHelp(usageString, options);
                return;
            }

            var specLocation = new URI(cli.getOptionValue(inputOpt));
            var eclipseConfig = new File(cli.getOptionValue(eclipseConfigOpt));
            var outputDir = new File(cli.getOptionValue(outputOpt));
            var distribution = cli.getOptionValue(distributionOpt, CodegenSettings.DEFAULT_DISTRIBUTION);
            var runtimePackage = CodegenSettings.requireJavaPackage(
                cli.getOptionValue(runtimePackageOpt, CodegenSettings.DEFAULT_RUNTIME_PACKAGE),
                "runtime package"
            );
            var modelPackage = CodegenSettings.requireJavaPackage(
                cli.getOptionValue(modelPackageOpt, runtimePackage + ".opensearch"),
                "model package"
            );
            var rootClientName = CodegenSettings.requireJavaTypePrefix(
                cli.getOptionValue(clientNameOpt, CodegenSettings.DEFAULT_ROOT_CLIENT_NAME),
                "root client name"
            );
            CodegenSettings.configureTypePackages(runtimePackage, modelPackage);

            LOGGER.info("Specification Location: {}", specLocation);
            LOGGER.info("Eclipse Configuration: {}", eclipseConfig);
            LOGGER.info("Output Directory: {}", outputDir);
            LOGGER.info("Distribution: {}", distribution);
            LOGGER.info("Runtime Package: {}", runtimePackage);
            LOGGER.info("Model Package: {}", modelPackage);
            LOGGER.info("Root Client Name: {}", rootClientName);

            Namespace root = parseSpec(specLocation, Overrides.forDistribution(distribution), modelPackage, rootClientName);

            cleanDirectory(outputDir);

            final var rootPackageOutputDir = new File(outputDir, root.getPackageName().replace('.', '/'));

            try (
                var ctx = ShapeRenderingContext.builder()
                    .withOutputDir(rootPackageOutputDir)
                    .withJavaCodeFormatter(b -> b.withRootDir(rootPackageOutputDir.toPath()).withEclipseFormatterConfig(eclipseConfig))
                    .withTemplateLoader(b -> b.withTemplatesResourceSubPath("/software/amazon/opensearch/client/codegen/templates"))
                    .build()
            ) {
                root.render(ctx);
            }
        } catch (ParseException e) {
            LOGGER.error("Argument Parsing Failed. Reason: {}", e.getMessage());

            var helpFormatter = HelpFormatter.builder().setPrintWriter(new PrintWriter(System.err)).get();
            helpFormatter.printHelp(usageString, options);

            System.exit(1);
        } catch (Throwable e) {
            LOGGER.fatal("Unexpected Error", e);
            System.exit(1);
        }
    }

    private static Namespace parseSpec(URI location, Overrides overrides, String modelPackage, String rootClientName)
        throws ApiSpecificationParseException {
        var spec = OpenApiSpecification.retrieve(location);
        spec = SpecificationRewriter.rewrite(spec, overrides);
        var transformer = new SpecTransformer(OPERATION_MATCHER, overrides, modelPackage, rootClientName);
        transformer.visit(spec);
        return transformer.getRoot();
    }

    private static void cleanDirectory(File dir) throws RenderException {
        if (!dir.exists()) {
            return;
        }
        try (Stream<Path> walker = Files.walk(dir.toPath())) {
            walker.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            throw new RenderException("Unable to cleanup output directory: " + dir, e);
        }
    }
}
