package com.rag.rag.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rag.rag.model.LLMRequest;
import com.rag.rag.model.LLMResponse;
import com.rag.rag.service.OllamaLLMService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Slf4j
@RequestMapping("/api/v1/llm")
@AllArgsConstructor
public class LLMRestController {

    private final OllamaLLMService chatService;

    @PostMapping("/chat")
    public ResponseEntity<LLMResponse> chat(@RequestBody LLMRequest llmRequest) {

        String chatResponse = chatService.chat(llmRequest.getQuery());

        return ResponseEntity.ok(new LLMResponse("success", chatResponse));
    }

}
