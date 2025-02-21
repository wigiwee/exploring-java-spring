package com.stockAdvisor.stockAdvisor;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.stockAdvisor.stockAdvisor.model.StockOrder;

public interface StockOrderRepository extends ListCrudRepository<StockOrder, Long> {

    List<StockOrder> findBySymbol(String symbol);

}
