package com.kata.supermarket;

import com.kata.supermarket.model.IProductOrder;
import com.kata.supermarket.model.OfferByWeight;
import com.kata.supermarket.model.Product;
import com.kata.supermarket.model.ProductOrderByWeight;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.kata.supermarket.type.WeightUnity.POUND;

@RunWith(JUnit4.class)
public class ProductOrderByWeightTest {
    @Test
    public void testOrderByWeightWithoutOffer() {
        Product tomatoes = new Product("Round tomatoes", 5);
        IProductOrder productOrder = new ProductOrderByWeight(tomatoes, 7, POUND);
        Assert.assertEquals(35d, productOrder.calculateProductOrderPrice());
    }
    @Test
    public void testOrderByWeightWithOffer() {
        Product tomatoes = new Product("Round tomatoes", 5);
        OfferByWeight tomatoesOffer = new OfferByWeight(3, POUND, 10);
        IProductOrder productOrder = new ProductOrderByWeight(tomatoes, 7, POUND, tomatoesOffer);
        Assert.assertEquals(25d, productOrder.calculateProductOrderPrice());
    }
}
