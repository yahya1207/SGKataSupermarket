package com.kata.supermarket.model;

import com.kata.supermarket.type.WeightUnity;

public class ProductOrderByWeight implements IProductOrder {

    private Product product;
    private int orderAmount;
    private WeightUnity orderUnity;
    private OfferByWeight offer;

    public ProductOrderByWeight(Product product, int orderAmount, WeightUnity orderUnity) {
        this.product = product;
        this.orderAmount = orderAmount;
        this.orderUnity = orderUnity;
    }
    public ProductOrderByWeight(Product product, int orderAmount, WeightUnity orderUnity, OfferByWeight offerByWeight) {
        this(product, orderAmount, orderUnity);
        this.offer = offerByWeight;
    }

    @Override
    public double calculateProductOrderPrice() {
        return product.getInitialPrice() * orderAmount;
    }
}
