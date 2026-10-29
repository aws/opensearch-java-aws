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
package software.amazon.opensearch.client.codegen.openapi;

import static software.amazon.opensearch.client.codegen.utils.Functional.ifNonnull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.schema.CoreSchema;
import software.amazon.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import software.amazon.opensearch.client.codegen.utils.Clone;
import software.amazon.opensearch.client.codegen.utils.Maps;
import software.amazon.opensearch.client.codegen.utils.builder.ObjectBuilderBase;
import software.amazon.opensearch.client.codegen.utils.builder.ToBuilder;
import software.amazon.opensearch.client.codegen.utils.json.JsonGenerator;

public final class OpenApiSpecification extends OpenApiElement<OpenApiSpecification> implements ToBuilder<OpenApiSpecification.Builder> {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final ParseOptions PARSE_OPTIONS = new ParseOptions();
    private static final OpenAPIV3Parser PARSER = new OpenAPIV3Parser();
    // The parser reads YAML with YAML 1.1 rules, which turn plain scalars such as `no`, `yes` and `y`
    // into booleans. Specs are emitted as YAML 1.2, where those are strings, so load them with the
    // YAML 1.2 core schema and hand the parser JSON instead.
    private static final LoadSettings YAML_SETTINGS = LoadSettings.builder()
        .setSchema(new CoreSchema())
        .setCodePointLimit(Integer.MAX_VALUE)
        .build();
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final Map<URI, OpenApiSpecification> SPECS = new HashMap<>();

    public static OpenApiSpecification retrieve(URI location) {
        if (SPECS.containsKey(location)) {
            return SPECS.get(location);
        }
        LOGGER.info("Parsing spec: {}", location);
        var result = PARSER.readContents(readAsJson(location), null, PARSE_OPTIONS);
        var openApi = result.getOpenAPI();
        if (openApi == null) {
            throw new ApiSpecificationParseException("Unable to parse spec: " + location, result.getMessages());
        }
        var spec = new OpenApiSpecification(location, openApi);
        SPECS.put(location, spec);
        return spec;
    }

    private static String readAsJson(URI location) {
        Object document;
        try (InputStream in = location.toURL().openStream()) {
            document = new Load(YAML_SETTINGS).loadFromInputStream(in);
        } catch (IOException e) {
            throw new ApiSpecificationParseException("Unable to read spec: " + location, e);
        }
        try {
            return JSON_MAPPER.writeValueAsString(document);
        } catch (JsonProcessingException e) {
            throw new ApiSpecificationParseException("Unable to convert spec to JSON: " + location, e);
        }
    }

    @Nonnull
    private final URI location;
    @Nullable
    private Map<String, OpenApiPath> paths;
    @Nullable
    private OpenApiComponents components;
    @Nonnull
    private final Map<OpenApiElement<?>, JsonPointer> elementPointerLookup = new HashMap<>();
    @Nonnull
    private final Map<JsonPointer, OpenApiElement<?>> pointerElementLookup = new HashMap<>();

    private OpenApiSpecification(@Nonnull Builder builder) {
        super();
        this.location = Objects.requireNonNull(builder.location, "location must not be null");
        setPaths(builder.paths);
        setComponents(builder.components);
    }

    private OpenApiSpecification(@Nonnull URI location, @Nonnull OpenAPI openApi) {
        super();
        this.location = Objects.requireNonNull(location, "location must not be null");
        Objects.requireNonNull(openApi, "openAPI must not be null");
        setPaths(children(openApi.getPaths(), OpenApiPath::new));
        setComponents(ifNonnull(openApi.getComponents(), OpenApiComponents::new));
    }

    @Override
    Optional<OpenApiSpecification> getSpecification() {
        return Optional.of(this);
    }

    @Override
    void initialize(@Nullable OpenApiElement<?> parent, @Nonnull JsonPointer pointer) {
        super.initialize(parent, pointer);
        initializeChildren("paths", paths);
        initializeChild("components", components);
    }

    void registerElement(@Nonnull OpenApiElement<?> element) {
        removeElement(element);
        var currPointer = element.getPointer();
        elementPointerLookup.put(element, currPointer);
        pointerElementLookup.put(currPointer, element);
    }

    void removeElement(@Nonnull OpenApiElement<?> element) {
        var ptr = elementPointerLookup.remove(element);
        if (ptr != null) {
            pointerElementLookup.remove(ptr);
        }
    }

    public Optional<OpenApiElement<?>> getElement(@Nonnull JsonPointer pointer) {
        return Optional.ofNullable(pointerElementLookup.get(pointer));
    }

    @Nonnull
    public Optional<Map<String, OpenApiPath>> getPaths() {
        return Maps.unmodifiableOpt(paths);
    }

    public void setPaths(@Nullable Map<String, OpenApiPath> paths) {
        this.paths = paths;
        initializeChildren("paths", paths);
    }

    @Nonnull
    public Optional<OpenApiComponents> getComponents() {
        return Optional.ofNullable(components);
    }

    public void setComponents(@Nullable OpenApiComponents components) {
        this.components = components;
        initializeChild("components", components);
    }

    @Nonnull
    public URI getLocation() {
        return location;
    }

    @Override
    protected void toJsonInner(JsonGenerator generator) {
        if (paths != null) {
            generator.writeField("paths", paths);
        }
        if (components != null) {
            generator.writeField("components", components);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OpenApiSpecification that = (OpenApiSpecification) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(location, that.location).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(location).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("location", location).toString();
    }

    @Override
    public @Nonnull OpenApiSpecification clone() {
        return toBuilder().build();
    }

    @Override
    public @Nonnull Builder toBuilder() {
        return builder().withLocation(location)
            .withPaths(ifNonnull(paths, Clone::clone))
            .withComponents(ifNonnull(components, Clone::clone));
    }

    public static @Nonnull Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ObjectBuilderBase<OpenApiSpecification, Builder> {
        private URI location;
        @Nullable
        private Map<String, OpenApiPath> paths;
        @Nullable
        private OpenApiComponents components;

        private Builder() {}

        @Nonnull
        @Override
        protected OpenApiSpecification construct() {
            return new OpenApiSpecification(this);
        }

        public @Nonnull Builder withLocation(@Nonnull URI location) {
            this.location = Objects.requireNonNull(location, "location must not be null");
            return this;
        }

        public @Nonnull Builder withPaths(@Nullable Map<String, OpenApiPath> paths) {
            this.paths = paths;
            return this;
        }

        public @Nonnull Builder withComponents(@Nullable OpenApiComponents components) {
            this.components = components;
            return this;
        }
    }
}
