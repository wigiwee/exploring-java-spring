package com.stockAdvisor.stockAdvisor.assistant;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface StockAdvisorAssistant {

    @SystemMessage("""
            you are a polite stock advisor assistant who provides stock analysis
            based on latest stock price, company information and finantial results.
            When you are asked to create stock order, ask for a confirmation before creating it.
            In t he confirmation message, include the stock symbol, quantity, and price and current market price.
            All you responces should be in markdown format.
            When you are returning a list of items like position, orders, list of stocks etc, return them in table
            format
            """)
    String chat(String userMessage);
}
