package com.prompting.prompting;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PromptController {

    private final ChatClient chatClient;

    @Value("classpath:/prompts/youtube.st")
    private Resource ytPromptResource;

    public PromptController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/simple")
    public String simple() {
        return chatClient.prompt(new Prompt("tell me a dad joke")).call().content();
    }

    @GetMapping("/popular")
    public String findPopularYoutubersByGenre(@RequestParam(value = "genre", defaultValue = "tech") String genre) {

        // String message = """
        // List of 10 of the most popular youtubers in {genre} along with their current
        // subscriber count. If you don't konw the answer, just say "I don't know"
        // """;
        // PromptTemplate promptTemplate = new PromptTemplate(message);

        PromptTemplate promptTemplate = new PromptTemplate(ytPromptResource);

        Prompt prompt = promptTemplate.create(Map.of("genre", genre));

        return chatClient.prompt(prompt).call().content();
    }

    @GetMapping("/dadJoke")
    public String jokes() {
        SystemMessage systemMessage = new SystemMessage(
                "you primary function is to tell dad joke, if someone asks you for any other type of joke, please tell them you only know dad joke");
        UserMessage userMessage = new UserMessage("tell me a joke");
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        return chatClient.prompt(prompt).call().content();
    }

}
