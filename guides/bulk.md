- [Bulk](#bulk)
  - [Bulk Indexing](#bulk-indexing)
  - [Bulk requests](#bulk-requests)

# Bulk

The [Bulk API](https://opensearch.org/docs/latest/api-reference/document-apis/bulk/) lets you add, update, or delete multiple documents in a single request.

## Bulk Indexing

Use the AWS client's Bulk API to send bounded batches of operations. The application
controls batch size and checks each response for failed operations.

```java
var documents = List.of(
    new IndexData("Document 1", "The text of document 1"),
    new IndexData("Document 2", "The text of document 2"),
    new IndexData("Document 3", "The text of document 3")
);
int batchSize = 2;
for (int start = 0; start < documents.size(); start += batchSize) {
    var batch = new BulkRequest.Builder().index("sample-index");
    for (int i = start; i < Math.min(start + batchSize, documents.size()); i++) {
        var id = "id" + (i + 1);
        var document = documents.get(i);
        batch.operations(op -> op.index(b -> b.id(id).document(document)));
    }
    var response = client.bulk(batch.build());
    if (response.errors()) {
        throw new IllegalStateException("A bulk batch contains failed operations: " + response.items());
    }
}
```

[IndexData](../samples/src/main/java/software/amazon/opensearch/client/samples/util/IndexData.java) is the sample data class.
See [BulkBatching.java](../samples/src/main/java/software/amazon/opensearch/client/samples/BulkBatching.java)
for the complete example. The standalone OSS client's `BulkIngester` helper is
not included in this AWS client.


## Bulk requests

```java
String indexName = "sample-index";
CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder().index(indexName).build();
client.indices().create(createIndexRequest);

ArrayList<BulkOperation> ops = new ArrayList<>();
IndexData doc1 = new IndexData("Document 1", "The text of document 1");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(indexName).id("id1").document(doc1))
).build());
IndexData doc2 = new IndexData("Document 2", "The text of document 2");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(indexName).id("id2").document(doc2))
).build());
IndexData doc3 = new IndexData("Document 3", "The text of document 3");
ops.add(new BulkOperation.Builder().index(
        IndexOperation.of(io -> io.index(indexName).id("id3").document(doc3))
).build());

BulkRequest.Builder bulkReq = new BulkRequest.Builder()
        .index(indexName)
        .operations(ops)
        .refresh(Refresh.WaitFor);
BulkResponse bulkResponse = client.bulk(bulkReq.build());
```

[IndexData](../samples/src/main/java/software/amazon/opensearch/client/samples/util/IndexData.java) refers to sample data class.

You can find a working sample of the above code in [Bulk.java](../samples/src/main/java/software/amazon/opensearch/client/samples/Bulk.java).