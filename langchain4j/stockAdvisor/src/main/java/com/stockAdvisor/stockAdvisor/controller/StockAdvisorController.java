package com.stockAdvisor.stockAdvisor.controller;

import org.springframework.web.bind.annotation.RestController;

import com.stockAdvisor.stockAdvisor.assistant.StockAdvisorAssistant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
public class StockAdvisorController {

    private final StockAdvisorAssistant assistant;

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {

        return assistant.chat(message);
    }

}
