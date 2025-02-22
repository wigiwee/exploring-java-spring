package com.langchain4j_demo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.langchain4j_demo.demo.dto.Assistant;
import com.langchain4j_demo.demo.dto.ChatRequest;
import com.langchain4j_demo.demo.model.BookModel;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenAIServiceImpl implements GenAIService {

    private final ChatLanguageModel openAIChatLanguageModel;

    private final Assistant assistant;

    @Override
    public String getResponse(ChatRequest request) {

        return assistant.chat(request.userId(), request.question());
    }

    public String getResponseSimple(ChatRequest request) {

        List<ChatMessage> messages = new ArrayList<>();

        messages.add(SystemMessage.from("respond politely"));
        messages.add(UserMessage.from(request.question()));

        return openAIChatLanguageModel.generate(messages).content().text();
    }

    @Override
    public BookModel getBookModelFromText(String question) {
        return assistant.extraBookFromText(question, "convert this book");
    }

}
