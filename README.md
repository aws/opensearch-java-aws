# AWS OpenSearch Java Data Client

This repository provides typed Java data-plane clients for:

- Amazon OpenSearch Service (AOS)
- Amazon OpenSearch Serverless (AOSS)

Both clients are shipped in the same JAR and use separate Java packages:

```text
software.amazon.awssdk.opensearch.client.aos
software.amazon.awssdk.opensearch.client.aoss
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
import software.amazon.awssdk.opensearch.client.aos.OpenSearchClient;
// Or: software.amazon.awssdk.opensearch.client.aoss.OpenSearchClient
```

The clients use the AWS SDK default credentials provider chain unless a
credentials provider is supplied explicitly.

## Build the client

Requires JDK 17 or newer.

Clone the repository and build the JAR:

```bash
git clone <repository-url>
cd opensearch-java-aws
./gradlew --no-daemon --max-workers=1 :java-client:jar
```

The generated local artifact is:

```text
java-client/build/libs/java-client-4.0.0-SNAPSHOT.jar
```

Until the artifact is published, another Gradle project can use the local JAR
for prototype testing:

```kotlin
dependencies {
    implementation(files("libs/java-client-4.0.0-SNAPSHOT.jar"))

    implementation(platform("software.amazon.awssdk:bom:<aws-sdk-version>"))
    implementation("software.amazon.awssdk:sdk-core")
    implementation("software.amazon.awssdk:auth")
    implementation("software.amazon.awssdk:http-auth-aws")
    implementation("software.amazon.awssdk:url-connection-client")
}
```

Raw file dependencies do not include transitive dependency metadata. The
consuming project must also provide the runtime dependencies declared in
`java-client/build.gradle.kts`; the example above shows the additional AWS SDK
dependencies needed by the SigV4 transport.

`software.amazon.awssdk:opensearch-data-client` is only a proposed Maven
coordinate. Do not publish or depend on it until the package metadata is
finalized.

## Quick start: AOS

The endpoint may be a full HTTPS URL or a bare host. The client signs requests
with the AOS SigV4 service name `es`.

```java
import java.util.Map;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.opensearch.client.aos.OpenSearchClient;
import software.amazon.awssdk.opensearch.client.aos.core.SearchResponse;
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
import software.amazon.awssdk.opensearch.client.aoss.OpenSearchClient;
import software.amazon.awssdk.opensearch.client.aoss.core.SearchResponse;
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

## Use AOS and AOSS in the same application

Both clients can be used in the same source file. Their generated model types
are intentionally isolated, so use fully qualified names when class names
overlap:

```java
import java.util.Map;
software.amazon.awssdk.opensearch.client.aos.OpenSearchClient aosClient =
    /* create AOS client */;
software.amazon.awssdk.opensearch.client.aoss.OpenSearchClient aossClient =
    /* create AOSS client */;

software.amazon.awssdk.opensearch.client.aos.core.SearchResponse<Map> aosResponse =
    aosClient.search(request -> request.index("aos-index"), Map.class);

software.amazon.awssdk.opensearch.client.aoss.core.SearchResponse<Map> aossResponse =
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
import software.amazon.awssdk.opensearch.client.aos.OpenSearchClient;
import software.amazon.awssdk.opensearch.client.aos.core.SearchResponse;
```

For AOSS, use:

```java
import software.amazon.awssdk.opensearch.client.aoss.OpenSearchClient;
import software.amazon.awssdk.opensearch.client.aoss.core.SearchResponse;
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
