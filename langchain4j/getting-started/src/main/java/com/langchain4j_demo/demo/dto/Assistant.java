package com.langchain4j_demo.demo.dto;

import com.langchain4j_demo.demo.model.BookModel;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface Assistant {

    @SystemMessage("""
            You are a personal assistant, try to respond in a fair and warm manner.
            if you don't know something, just say "I don't know".
            """)
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @SystemMessage("""
            Extract information about the book from {{text}}
            """)
    BookModel extraBookFromText(@V("text") String text, @UserMessage String userMessage);
}
