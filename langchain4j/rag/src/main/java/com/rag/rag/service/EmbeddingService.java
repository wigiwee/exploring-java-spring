package com.rag.rag.service;

import org.springframework.stereotype.Service;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmbeddingService {

    private final EmbeddingModel embeddingModel;

    private final EmbeddingStore embeddingStore;

    public void loadSingleDocument() {
        Document document = loadDocument("/home/happypotter/test.pdf");

        EmbeddingStoreIngestor embeddingStoreIngestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(DocumentSplitters.recursive(400, 50))
                .embeddingModel(embeddingModel)
                .embeddingStore(embeddingStore)
                .build();

        embeddingStoreIngestor.ingest(document);
    }

}
