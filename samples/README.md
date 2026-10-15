# AWS OpenSearch Java client samples

The samples use the client JAR built by this repository, including its shared
runtime and generated AOS and AOSS classes. JDK 21 or newer is required.

```sh
./gradlew :samples:build
```

## Search an AOS domain or AOSS collection with IAM

`AwsSearch` searches an existing index. It uses the AWS SDK default credential
provider chain and verifies the server's TLS certificate.

Set the endpoint, index, and signing region:

```sh
export OPENSEARCH_ENDPOINT='https://your-domain-endpoint'
export OPENSEARCH_INDEX='your-existing-index'
export AWS_REGION='us-east-1'
./gradlew :samples:run -Dsamples.mainClass=AwsSearch --args=aos
```

For Serverless, set `OPENSEARCH_ENDPOINT` to the collection's OpenSearch endpoint:

```sh
./gradlew :samples:run -Dsamples.mainClass=AwsSearch --args=aoss
```

The example uses `software.amazon.opensearch.client.aos.OpenSearchClient` for
AOS and `software.amazon.opensearch.client.aoss.OpenSearchClient` for AOSS.
Their `create` methods select the `es` and `aoss` signing service names respectively.
The configured identity must have access to search the selected index.

## AOS API examples

The remaining examples use the AOS client through `SampleClient` with HTTP basic
authentication. They read `HOST`, `PORT`, `HTTPS`, `USERNAME`, and `PASSWORD` from
the environment; defaults are `localhost`, `9200`, `true`, `admin`, and `admin`.
`SampleClient` retains the local-development setup that accepts self-signed
certificates and disables hostname verification. Use it only with a trusted
development cluster. Use `AwsSearch` for the IAM-authenticated AWS example.

Examples create and delete their own named indexes, templates, or other resources.
Run them on a disposable development cluster. The neural-search example also
changes cluster settings and requires ML model support.

```sh
./gradlew :samples:run -Dsamples.mainClass=IndexingBasics
./gradlew :samples:run -Dsamples.mainClass=BulkBatching
./gradlew :samples:run -Dsamples.mainClass=knn.KnnBasics
```

`BulkBatching` sends bounded batches through the Bulk API. The standalone OSS
client's `BulkIngester` helper is not included in the AWS client.

You can also specify a fully qualified sample class:

```sh
./gradlew :samples:run \
  -Dsamples.mainClass=software.amazon.opensearch.client.samples.AwsSearch \
  --args=aos
```
