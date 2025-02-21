package com.stockAdvisor.stockAdvisor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.stockAdvisor.stockAdvisor.config.StockAPIConfig;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class StockInformationService {

    private final StockAPIConfig stockAPIConfig;
    private final RestClient restclient;

    @Tool("returns the stock price for the given stock symbol")
    public String getStockPrice(@P("Stock symbol seperated by ,") String stockSymbol) {
        log.info("fetching stock price for stock symbol : {}", stockSymbol);
        return fetchData("/quote/" + stockSymbol);
    }

    @Tool("return company profile for the given stock symbols")
    public String getCompanyProfile(@P("stock symbol seperated by ,") String stockSymbol) {
        log.info("fetching company profile for stock symbol : {}", stockSymbol);
        return fetchData("/profile/" + stockSymbol);
    }

    @Tool("return the balance sheet statements for the give stock symbol")
    public List<String> getBalanceSheetStatements(@P("stock symbol seperated by ,") String stockSymbol) {
        log.info("fetching balance sheet for stock symbol : {}", stockSymbol);
        return fetchDataForMultipleSymbols(stockSymbol, "/balance-sheet-statements/");
    }

    @Tool("returns the income statements for the give stock symbol")
    public List<String> getIncomeStatements(@P("stock symbol seperated by ,") String stockSymbol) {
        log.info("fetching income statement for stock symbol : {}", stockSymbol);

        return fetchDataForMultipleSymbols(stockSymbol, "/income-statement/");
    }

    @Tool("return the cash flow statements for the give stock symbol")
    public List<String> getCashFlowStatements(@P("stock symbol seperated by ,") String stockSymbol) {
        log.info("fetching cash flow statements for stock symbol : {}", stockSymbol);

        return fetchDataForMultipleSymbols(stockSymbol, "/cash-flow-statement/");
    }

    private List<String> fetchDataForMultipleSymbols(String stockSymbol, String s) {
        List<String> data = new ArrayList<>();
        for (String symbol : stockSymbol.split(",")) {
            String response = fetchData(s + symbol);
            data.add(response);
        }
        return data;
    }

    private String fetchData(String s) {
        return restclient.get()
                .uri(s + "?apikey=" + stockAPIConfig.getApiKey())
                .retrieve()
                .body(String.class)
                .replaceAll("\\s", " ").trim();
    }
}
