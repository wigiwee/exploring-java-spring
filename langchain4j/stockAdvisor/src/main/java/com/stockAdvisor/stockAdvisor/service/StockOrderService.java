package com.stockAdvisor.stockAdvisor.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stockAdvisor.stockAdvisor.StockOrderRepository;
import com.stockAdvisor.stockAdvisor.model.OrderType;
import com.stockAdvisor.stockAdvisor.model.StockHoldingDetails;
import com.stockAdvisor.stockAdvisor.model.StockOrder;

import dev.langchain4j.agent.tool.Tool;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockOrderService {

    private final StockOrderRepository stockOrderRepository;

    @Tool
    public StockOrder createOrder(StockOrder order) {
        return stockOrderRepository.save(new StockOrder(null, "testuser", order.symbol(), order.quantity(),
                order.price(), order.orderType(), LocalDateTime.now()));
    }

    public List<StockOrder> getAllOrders() {
        return stockOrderRepository.findAll();
    }

    public StockOrder getOrderById(Long id) {
        return stockOrderRepository.findById(id).orElse(null);
    }

    @Tool
    public List<StockHoldingDetails> getStockHoldingDetails() {
        return stockOrderRepository.findAll().stream()
                .collect(Collectors.groupingBy(StockOrder::symbol,
                        Collectors.summingInt(
                                order -> order.orderType() == OrderType.BUY ? order.quantity() : -order.quantity())))
                .entrySet().stream()
                .map(entity -> new StockHoldingDetails(entity.getKey(), entity.getValue()))
                .collect(Collectors.toList());
    }
}
