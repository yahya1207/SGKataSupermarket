package com.kata.supermarket.service;

import com.kata.supermarket.model.Product;
import com.kata.supermarket.repository.OfferRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_DOWN;

public class OrderCalculator {

    private IProductOrderService orderService = new ProductOrderService(OfferRepository.getInstance());
    private Map<Product, BigDecimal> productOrders = new HashMap<>();

    public OrderCalculator addProductOrder(Product product, BigDecimal orderAmount) {
        if (orderAmount == null || ZERO.compareTo(orderAmount) >= 0) {
            throw new IllegalArgumentException("Order amount should be greater than zero. Order amount = " + orderAmount);
        }
        productOrders.compute(product, (k, v) -> v == null ? orderAmount : v.add(orderAmount));
        return this;
    }

    public BigDecimal getTotalPrice() {
        return productOrders.entrySet().stream()
                .map(order -> orderService.getCalculatedPrice(order.getKey(), order.getValue()))
                .reduce(ZERO, BigDecimal::add);
    }
}
