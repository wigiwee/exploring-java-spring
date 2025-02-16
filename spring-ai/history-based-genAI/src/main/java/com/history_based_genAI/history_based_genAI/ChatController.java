package com.history_based_genAI.history_based_genAI;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    private final List<String> censoredWords = List.of("banana", "apples");

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(
                        new SafeGuardAdvisor(censoredWords),
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    @GetMapping("/one")
    public String chat(@RequestParam String message) {
        return chatClient.prompt()
                .advisors(advisor -> advisor.param("chat_memory_conversation_id", "one"))
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/two")
    public String chat2(@RequestParam String message) {
        return chatClient.prompt()
                .advisors(advisor -> advisor.param("chat_memory_conversation_id", "two"))
                .user(message)
                .call()
                .content();
    }
}