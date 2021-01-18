package com.kata.supermarket;

import com.kata.supermarket.model.Offer;
import com.kata.supermarket.model.Product;
import com.kata.supermarket.repository.IOfferRepository;
import com.kata.supermarket.repository.OfferRepository;
import com.kata.supermarket.service.OrderCalculator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_DOWN;

@RunWith(JUnit4.class)
public class OrderCalculatorTest {
    private OrderCalculator newOrder;

    @Before
    public void setUpProductOrders() {
        newOrder = new OrderCalculator();

        //buy 8 bottles of milk
        Product milk = new Product("Candia milk", valueOf(1));
        // buy 2 cans without offer
        Product can = new Product("coca cola can", valueOf(3));
        // buy 7 pounds of tomatoes
        Product tomatoes = new Product("Round tomatoes", valueOf(5));

        //Offers
        Offer milkOffer = new Offer(valueOf(6), valueOf(5));
        Offer tomatoesOffer = new Offer(valueOf(3), valueOf(10));
        IOfferRepository repository = OfferRepository.getInstance();
        repository.addOffer(milk, milkOffer);
        repository.addOffer(tomatoes, tomatoesOffer);

        newOrder.addProductOrder(milk, valueOf(8))
                .addProductOrder(can, valueOf(2))
                .addProductOrder(tomatoes, valueOf(7));

    }

    @Test
    public void testOrderWithDifferentProductOrderType() {
        BigDecimal expectedResult = valueOf(38).setScale(2, HALF_DOWN);
        Assert.assertEquals(expectedResult, newOrder.getTotalPrice());
    }
}
