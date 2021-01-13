package com.kata.supermarket.model;

public class ProductOrderByPiece implements IProductOrder {

    private Product product;
    private int orderAmount;

    public ProductOrderByPiece(Product product, int orderAmount) {
        this.product = product;
        this.orderAmount = orderAmount;
    }

    public ProductOrderByPiece(Product product, int orderAmount, Offer offer) {
        this(product, orderAmount);
    }

    @Override
    public double calculateProductOrderPrice() {
        return product.getInitialPrice() * orderAmount;
    }
}
