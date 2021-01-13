package com.kata.supermarket.model;

import com.kata.supermarket.type.WeightUnity;

public class ProductOrderByWeight implements IProductOrder {

    private Product product;
    private int orderAmount;
    private WeightUnity orderUnity;

    public ProductOrderByWeight(Product product, int orderAmount, WeightUnity orderUnity) {
        this.product = product;
        this.orderAmount = orderAmount;
        this.orderUnity = orderUnity;
    }

    @Override
    public double calculateProductOrderPrice() {
        return product.getInitialPrice() * orderAmount;
    }
}
