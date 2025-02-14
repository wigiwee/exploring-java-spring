package com.function_calling.function_calling;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CityController {

    private final ChatClient chatClient;

    public CityController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/cities")
    public String cities(@RequestParam(value = "message") String message) {
        System.out.println("i got executed");
        SystemMessage systemMessage = new SystemMessage(
                "you are are helpful ai assistant answering questions about cities around the world");
        UserMessage userMessage = new UserMessage(message);

        return chatClient.prompt(new Prompt(List.of(systemMessage, userMessage))).functions("currentWeatherFunction")
                .call().content();

    }

}
