package com.kata.supermarket;

import com.kata.supermarket.model.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.kata.supermarket.type.WeightUnity.POUND;

@RunWith(JUnit4.class)
public class OrdersTest {
    private Order newOrder;

    @Before
    public void setUpProductOrders() {
        newOrder = new Order();

        //buy 8 bottles of milk
        Product milk = new Product("Candia milk", 1);
        Offer milkOffer = new Offer(6, 5);
        newOrder.addOrderItem(new ProductOrderByPiece(milk, 8, milkOffer));

        // buy 2 cans without offer
        Product can = new Product("coca cola can", 3);
        newOrder.addOrderItem(new ProductOrderByPiece(can, 2, null));

        // buy 7 pounds of tomatoes
        Product tomatoes = new Product("Round tomatoes", 5);
        OfferByWeight tomatoesOffer = new OfferByWeight(3, POUND, 10);
        newOrder.addOrderItem(new ProductOrderByWeight(tomatoes, 7, POUND, tomatoesOffer));

    }

    @Test
    public void testOrderWithDifferentProductOrderType() {
        Assert.assertEquals(38d, newOrder.calculateTotal());
    }
}
