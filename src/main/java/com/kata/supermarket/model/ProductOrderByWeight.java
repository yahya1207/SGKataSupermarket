package com.kata.supermarket.model;

import com.kata.supermarket.type.WeightUnity;

public class ProductOrderByWeight implements IProductOrder {


    public ProductOrderByWeight(Product product, int orderAmount, WeightUnity orderUnity) {
    }

    @Override
    public double calculateProductOrderPrice() {
        return 0;
    }

}
