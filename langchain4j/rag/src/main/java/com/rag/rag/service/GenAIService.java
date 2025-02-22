package com.rag.rag.service;

import org.springframework.stereotype.Service;

import com.rag.rag.model.ChatRequest;
import com.rag.rag.model.ChatResponse;
import com.rag.rag.model.RAGAssistant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GenAIService {

    private final RAGAssistant ragAssistant;

    public String getChatResponse(ChatRequest request) {
        return ragAssistant.chat(request.memoryId(), request.question());
    }
}
