package com.kata.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    List<IProductOrder> orders = new ArrayList<>();

    public void addOrderItem(IProductOrder productOrder) {
        orders.add(productOrder);
    }

    public double calculateTotal() {
        return orders.stream()
                .mapToDouble(IProductOrder::calculateProductOrderPrice)
                .sum();
    }
}
