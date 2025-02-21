package com.stockAdvisor.stockAdvisor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

@Configuration
public class AssistantConfig {

    @Bean
    ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(20);
    }
}
