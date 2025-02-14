package com.function_calling.function_calling;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Slf4j
public class CityController {

    private final ChatClient chatClient;

    public CityController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/cities")
    public String cities(@RequestParam(value = "message") String message) {
        log.info("received request at /cities with prompt: " + message);
        SystemMessage systemMessage = new SystemMessage(
                "You are a helpful AI assistant answering questions about cities around the world. " +
                        "If the user asks about the weather, use the 'currentWeatherForCityFunction' to provide accurate information.");
        UserMessage userMessage = new UserMessage(message);

        return chatClient.prompt(new Prompt(List.of(systemMessage, userMessage)))
                .functions("currentWeatherForCityFunction")
                .call().content();

    }

}
