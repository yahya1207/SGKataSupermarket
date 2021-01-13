package com.kata.supermarket.model;

public class Product {

    private String name;
    private int initialPrice;

    public Product(String name, int initialPrice) {
        this.name = name;
        this.initialPrice = initialPrice;
    }

    public String getName() {
        return name;
    }

    public int getInitialPrice() {
        return initialPrice;
    }
}
