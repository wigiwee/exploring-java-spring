package com.rag.rag.model;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface RAGAssistant {

    @SystemMessage("""
            You are a helpfun assistant. Try to respond in a fair and warm manner.
            i have shared few files to you, if the user asked something, check the files
            for more, latest and relevant information,
            make sure to give user only relevant information only.
            If you don't know answer, just say "i don't know".
            """)
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
