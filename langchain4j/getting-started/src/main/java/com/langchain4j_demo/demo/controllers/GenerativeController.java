package com.langchain4j_demo.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.langchain4j_demo.demo.dto.ChatRequest;
import com.langchain4j_demo.demo.dto.ChatResponse;
import com.langchain4j_demo.demo.model.BookModel;
import com.langchain4j_demo.demo.service.GenAIService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class GenerativeController {

    private final GenAIService genAIService;

    @PostMapping("")
    public ChatResponse getChatResponse(@RequestBody ChatRequest chatRequest) {

        return new ChatResponse(genAIService.getResponse(chatRequest));
    }

    @PostMapping("/book")
    public BookModel getBookModel(@RequestBody ChatRequest request) {
        return genAIService.getBookModelFromText(request.question());

    }

}
