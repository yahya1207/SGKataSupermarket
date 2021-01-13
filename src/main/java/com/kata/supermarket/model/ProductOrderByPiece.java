package com.kata.supermarket.model;

public class ProductOrderByPiece implements IProductOrder {

    public ProductOrderByPiece(Product product, int orderAmount) {
    }

    @Override
    public double calculateProductOrderPrice() {
        return 0;
    }
}
