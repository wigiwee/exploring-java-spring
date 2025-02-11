package com.rag.rag.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class OllamaLLMService {

    private OllamaChatModel ollamaChatModel;

    public String chat(String query) {

        // Prompt prompt = new Prompt(query);

        String message = """
                <INST>You are an AI Assistant that can answer you questions. if you don't know the
                answer, don't make suggestions just say "I don't konw". </INST>
                content: {content}
                question: {input}
                """;

        String content = """
                the user is a third year computer engineering student, he is trying to understand llm's
                """;
        PromptTemplate promptTemplate = new PromptTemplate(message);

        Prompt prompt = promptTemplate.create(Map.of("input", query, "content", content));

        String response = ollamaChatModel.call(prompt).getResult().getOutput().getText();

        return response;
    }

}
