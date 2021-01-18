package com.kata.supermarket.service;

import com.kata.supermarket.model.Product;

import java.math.BigDecimal;

public interface IProductOrderService {
    BigDecimal getCalculatedPrice(Product product, BigDecimal orderAmount);
}
