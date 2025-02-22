package com.rag.rag.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rag.rag.model.ChatRequest;
import com.rag.rag.model.ChatResponse;
import com.rag.rag.service.EmbeddingService;
import com.rag.rag.service.GenAIService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
@Slf4j
public class ChatController {

    private final EmbeddingService embeddingService;

    private final GenAIService genAIService;

    @GetMapping("/load")
    public void loadSingleDoc() {
        embeddingService.loadSingleDocument();
        log.info("loaded single doc");
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        log.info("received " + request.question());
        return new ChatResponse(genAIService.getChatResponse(request));
    }

}
