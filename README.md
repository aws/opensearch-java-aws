# AWS OpenSearch Java Data Client

This repository provides typed Java data-plane clients for:

- Amazon OpenSearch Service (AOS)
- Amazon OpenSearch Serverless (AOSS)

Both clients are shipped in the same JAR and use separate Java packages:

```text
software.amazon.opensearch.client.aos
software.amazon.opensearch.client.aoss
```

> Project status: prototype. The final Maven group ID, artifact ID, POM metadata,
> and release process have not yet been approved.

## Client packages

| Service | Synchronous client | Asynchronous client | SigV4 service name |
| --- | --- | --- | --- |
| AOS | `aos.OpenSearchClient` | `aos.OpenSearchAsyncClient` | `es` |
| AOSS | `aoss.OpenSearchClient` | `aoss.OpenSearchAsyncClient` | `aoss` |

Use these imports:

```java
import software.amazon.opensearch.client.aos.OpenSearchClient;
// Or: software.amazon.opensearch.client.aoss.OpenSearchClient
```

The clients use the AWS SDK default credentials provider chain unless a
credentials provider is supplied explicitly.

## Build the client

The client runs on Java 8 or newer and uses Jackson 2 by default. The same
multi-release JAR also includes an optional Jackson 3 mapper for Java 21 or newer.
Building this repository requires JDK 21 or newer.

Clone the repository and build the JAR:

```bash
git clone <repository-url>
cd opensearch-java-aws
./gradlew --no-daemon --max-workers=1 :java-client:jar
```

Run the client tests against the packaged JAR on Java 8:

```bash
./gradlew :java-client:java8Test
```

Gradle locates or downloads a Java 8 toolchain for this task; keep JDK 21 or newer
as the build JDK.

Run the default mapper tests and the Jackson 3 tests on the build JDK:

```bash
./gradlew :java-client:unitTest
```

The generated local artifact is `java-client/build/libs/java-client-<version>-SNAPSHOT.jar`,
where `<version>` is `systemProp.version` in [gradle.properties](gradle.properties).

### Depending on the published artifact

The Maven coordinate is `software.amazon.opensearch:opensearch-java`, published to
[Maven Central](https://central.sonatype.com/artifact/software.amazon.opensearch/opensearch-java),
which lists the latest release.

The AWS SDK artifacts needed by the SigV4 transport are published as an
**optional feature** rather than as ordinary transitive dependencies, because the
Apache HTTP client transport does not need them. Either way you must declare an
HTTP client yourself — the client takes one as a constructor argument.

Gradle:

```kotlin
dependencies {
    implementation("software.amazon.opensearch:opensearch-java:<version>")

    implementation(platform("software.amazon.awssdk:bom:<aws-sdk-version>"))
    implementation("software.amazon.awssdk:sdk-core")
    implementation("software.amazon.awssdk:auth")
    implementation("software.amazon.awssdk:http-auth-aws")

    // Pick an HTTP client. `implementation`, not `runtimeOnly`: your own code
    // constructs it and passes it to the client.
    implementation("software.amazon.awssdk:url-connection-client")   // synchronous
    implementation("software.amazon.awssdk:netty-nio-client")        // asynchronous
}
```

Requesting the feature by capability works too, but the module must then be
declared **twice** — a capability request resolves to that variant alone, which
carries only the AWS SDK artifacts and none of the client's own dependencies:

```kotlin
dependencies {
    implementation("software.amazon.opensearch:opensearch-java:<version>")
    implementation("software.amazon.opensearch:opensearch-java:<version>") {
        capabilities {
            requireCapability("software.amazon.opensearch:opensearch-java-aws-sdk2-support")
        }
    }
    implementation("software.amazon.awssdk:url-connection-client:<aws-sdk-version>")
}
```

Maven does not resolve optional dependencies transitively, so the AWS SDK
artifacts always have to be declared. Use the AWS SDK BOM to keep versions
aligned:

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>software.amazon.awssdk</groupId>
      <artifactId>bom</artifactId>
      <version>${aws.sdk.version}</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>software.amazon.opensearch</groupId>
    <artifactId>opensearch-java</artifactId>
    <version>${opensearch.java.version}</version>
  </dependency>
  <dependency><groupId>software.amazon.awssdk</groupId><artifactId>sdk-core</artifactId></dependency>
  <dependency><groupId>software.amazon.awssdk</groupId><artifactId>auth</artifactId></dependency>
  <dependency><groupId>software.amazon.awssdk</groupId><artifactId>http-auth-aws</artifactId></dependency>
  <!-- synchronous -->
  <dependency><groupId>software.amazon.awssdk</groupId><artifactId>url-connection-client</artifactId></dependency>
  <!-- asynchronous -->
  <dependency><groupId>software.amazon.awssdk</groupId><artifactId>netty-nio-client</artifactId></dependency>
</dependencies>
```

The published metadata names the AWS SDK version this client is built and tested
against. Importing your own BOM, as above, overrides it. Going far below that
version will break: the SigV4 transport calls
`ContentStreamProvider.fromByteArrayUnsafe`, which does not exist before AWS SDK
2.25.69, and such a mismatch surfaces as a `NoSuchMethodError` at request time
rather than as a resolution failure.

### Using a locally built JAR

For prototype testing before a release exists, a Gradle project can consume the
JAR directly. Raw file dependencies carry no metadata, so every runtime
dependency declared in `java-client/build.gradle.kts` has to be repeated by the
consuming project — the AWS SDK artifacts below are only the ones the SigV4
transport needs:

```kotlin
dependencies {
    implementation(files("libs/java-client-<version>-SNAPSHOT.jar"))

    implementation(platform("software.amazon.awssdk:bom:<aws-sdk-version>"))
    implementation("software.amazon.awssdk:sdk-core")
    implementation("software.amazon.awssdk:auth")
    implementation("software.amazon.awssdk:http-auth-aws")
    implementation("software.amazon.awssdk:url-connection-client")
}
```

### Using Jackson 3 on Java 21+

Jackson 2 remains the default on every Java version. To select Jackson 3, add
`tools.jackson.core:jackson-databind:3.2.2` to your application dependencies:

```kotlin
implementation("tools.jackson.core:jackson-databind:3.2.2")
```

Then pass the Jackson 3 mapper to the transport:

```java
import software.amazon.opensearch.client.json.jackson3.JacksonJsonpMapper;
import software.amazon.opensearch.client.transport.aws.AwsSdk2TransportOptions;

AwsSdk2TransportOptions options = AwsSdk2TransportOptions.builder()
    .setMapper(new JacksonJsonpMapper())
    .build();
```

Use these options when constructing `AwsSdk2Transport`. For the Apache transport,
pass the same mapper to `ApacheHttpClient5TransportBuilder.setMapper(...)`.
The adapter is packaged under `META-INF/versions/21`; Java 8 and Java 17 applications
use the default Jackson 2 mapper. Jackson 3 dependencies are optional and are not
added transitively to Java 8 applications.

## Quick start: AOS

The endpoint may be a full HTTPS URL or a bare host. The client signs requests
with the AOS SigV4 service name `es`.

```java
import java.util.Map;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos.core.SearchResponse;
import software.amazon.awssdk.regions.Region;

try (SdkHttpClient httpClient = UrlConnectionHttpClient.builder().build()) {
    OpenSearchClient client = OpenSearchClient.create(
        httpClient,
        System.getenv("AOS_ENDPOINT"),
        Region.US_EAST_1,
        null
    );

    SearchResponse<Map> response =
        client.search(request -> request.index("books"), Map.class);

    response.hits().hits().forEach(hit -> System.out.println(hit.source()));
}
```

For an AOS domain configured with basic authentication, construct the client
with the Apache HTTP Client 5 transport and a basic credentials provider.

## Quick start: AOSS

The AOSS client signs requests with the SigV4 service name `aoss`.

```java
import java.util.Map;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.opensearch.client.aoss.OpenSearchClient;
import software.amazon.opensearch.client.aoss.core.SearchResponse;
import software.amazon.awssdk.regions.Region;

try (SdkHttpClient httpClient = UrlConnectionHttpClient.builder().build()) {
    OpenSearchClient client = OpenSearchClient.create(
        httpClient,
        System.getenv("AOSS_ENDPOINT"),
        Region.US_EAST_1,
        null
    );

    SearchResponse<Map> response =
        client.search(request -> request.index("books"), Map.class);

    response.hits().hits().forEach(hit -> System.out.println(hit.source()));
}
```

The caller's IAM principal must also be allowed by the collection's network,
encryption, and data access policies.

These search examples use POST and work with `UrlConnectionHttpClient`.
Optional GET bodies are omitted when none of their body fields are set. For
example, AOSS snapshot listing without `sourceCollectionId` works with
`UrlConnectionHttpClient`.

Requests that need a GET body, such as cross-collection snapshot listing with
`sourceCollectionId`, ML profiling with body filters, or CAT PIT segments, need
an HTTP client that preserves GET bodies. For these calls, add the
`software.amazon.awssdk:aws-crt-client` dependency and use
`software.amazon.awssdk.http.crt.AwsCrtHttpClient.builder().build()`.
`AwsSdk2Transport` throws `TransportException` for GET bodies with
`UrlConnectionHttpClient`, which would otherwise rewrite the signed request to
POST. This also applies to explicitly supplied generic GET bodies such as `{}` or
an empty string. DELETE bodies are supported by `UrlConnectionHttpClient`.

When no ML profile body fields are set, the server now applies the defaults and
model/task IDs from the request URL. This can produce different results from the
previous empty `{}` body. Explicit values such as `returnAllModels(false)` or an
empty list remain in the body and require an HTTP client that supports GET bodies.

## Use AOS and AOSS in the same application

Both clients can be used in the same source file. Their generated model types
are intentionally isolated, so use fully qualified names when class names
overlap:

```java
import java.util.Map;
software.amazon.opensearch.client.aos.OpenSearchClient aosClient =
    /* create AOS client */;
software.amazon.opensearch.client.aoss.OpenSearchClient aossClient =
    /* create AOSS client */;

software.amazon.opensearch.client.aos.core.SearchResponse<Map> aosResponse =
    aosClient.search(request -> request.index("aos-index"), Map.class);

software.amazon.opensearch.client.aoss.core.SearchResponse<Map> aossResponse =
    aossClient.search(request -> request.index("aoss-index"), Map.class);
```

Do not pass request or response model objects from one package to the other.

## Migrate from `opensearch-java`

Existing OpenSearch Java client code typically starts with:

```java
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.SearchResponse;
```

For AOS, change the imports to:

```java
import software.amazon.opensearch.client.aos.OpenSearchClient;
import software.amazon.opensearch.client.aos.core.SearchResponse;
```

For AOSS, use:

```java
import software.amazon.opensearch.client.aoss.OpenSearchClient;
import software.amazon.opensearch.client.aoss.core.SearchResponse;
```

The new factories configure the correct SigV4 service name, so callers do not
manually select `es` or `aoss`.

## Code generation

The clients are generated independently from the OpenSearch API specification:

```text
OpenSearch API specification
├── AOS overlays and filters  -> AOS full specification  -> aos package
└── AOSS overlays/allowlist   -> AOSS full specification -> aoss package
```

Generated source directories:

```text
java-client/src/generated/aos
java-client/src/generated/aoss
```

Regenerate both clients with:

```bash
./gradlew --no-daemon --max-workers=1 :java-codegen:generateClients
```

By default, the generator reads distribution specifications from the sibling
`../opensearch-api-docs/build` directory. Use
`-PdistributionSpecsDir=<directory>` to provide another location.

Do not manually edit files under `java-client/src/generated`. Change the API
specification, overlay, allowlist, or generator instead.

## Testing

Run the code generation, unit, formatting, and artifact checks:

```bash
./gradlew --no-daemon --max-workers=1 \
  :java-codegen:test \
  :java-client:unitTest \
  :java-client:spotlessJavaCheck \
  :java-codegen:spotlessJavaCheck \
  :java-client:jar \
  :java-client:sourcesJar \
  :java-client:javadocJar
```

Real-resource integration tests are opt-in. Configure endpoints and AWS
credentials outside the repository; never commit credentials or resource
secrets.

Run them explicitly with:

```bash
./gradlew --no-daemon --max-workers=1 :java-client:realResourceTest
```

## Current limitations

- The specialized `Bulk`, `Index`, `Create`, `Update`, `Mget`, and `Msearch`
  APIs are available in both packages. `Termvectors` is available only in AOS
  because it is excluded from the AOSS API surface.
- The final Maven coordinate, publication metadata, and release process remain
  open decisions.
- AOS and AOSS models are separate types even when their API shapes match.

## Security

See [AWS Security](https://aws.amazon.com/security/) for information about
reporting security issues. Do not disclose credentials in issues, examples,
logs, or test fixtures.

## License

This project is licensed under the Apache License 2.0. See
[LICENSE.txt](LICENSE.txt).

## Copyright

Copyright OpenSearch Contributors. See [NOTICE.txt](NOTICE.txt).
