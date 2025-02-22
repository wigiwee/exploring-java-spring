package com.langchain4j_demo.demo.service;

import com.langchain4j_demo.demo.dto.ChatRequest;
import com.langchain4j_demo.demo.model.BookModel;

public interface GenAIService {

    String getResponse(ChatRequest request);

    BookModel getBookModelFromText(String question);
}