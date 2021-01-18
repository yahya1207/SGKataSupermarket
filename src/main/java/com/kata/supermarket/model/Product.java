package com.kata.supermarket.model;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_DOWN;

public class Product {

    private String name;
    private BigDecimal initialPrice;

    public Product(String name, BigDecimal initialPrice) {
        if (initialPrice == null || ZERO.compareTo(initialPrice) >= 0) {
            throw new IllegalArgumentException("Initial price should be greater than zero. Initial price = " + initialPrice);
        }
        this.name = name;
        this.initialPrice = initialPrice.setScale(2, HALF_DOWN);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
