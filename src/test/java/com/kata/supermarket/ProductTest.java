package com.kata.supermarket;

import com.kata.supermarket.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.math.BigDecimal.valueOf;

@RunWith(JUnit4.class)
public class ProductTest {

    @Test(expected = IllegalArgumentException.class)
    public void testProductWithPriceZero() {
        new Product("product", valueOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductWithPriceLessThanZero() {
        new Product("product", valueOf(-5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductWithPriceNull() {
        new Product("product", null);
    }

    @Test
    public void testProductCreation() {
        new Product("product", valueOf(6));
    }

}
