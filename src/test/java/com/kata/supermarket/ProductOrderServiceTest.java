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
public class ProductOrderServiceTest {

    private IOfferRepository offerRepository;

    @Before
    public void setUp() {
        offerRepository = OfferRepository.getInstance();
    }

    @Test
    public void testOrderWithoutOffer() {
        offerRepository.clearOffers();
        Product milk = new Product("Candia milk", new BigDecimal(1));

        BigDecimal expectedResult = valueOf(3).setScale(2, HALF_DOWN);
        Assert.assertEquals(expectedResult,
                new OrderCalculator().addProductOrder(milk, valueOf(3))
                        .getTotalPrice());
    }

    @Test
    public void testOrderWithOffer() {
        //Available products
        Product tomatoes = new Product("tomatoes", new BigDecimal(1.8));
        Product milk = new Product("Candia milk", new BigDecimal(1));
        //Available offers
        Offer tomatoesOffer = new Offer(valueOf(3), valueOf(4.5));
        Offer milkOffer = new Offer(valueOf(6), valueOf(5));

        offerRepository.addOffer(tomatoes, tomatoesOffer);
        offerRepository.addOffer(milk, milkOffer);

        BigDecimal expectedResult = valueOf(15.1).setScale(2, HALF_DOWN);
        Assert.assertEquals(expectedResult,
                new OrderCalculator().addProductOrder(tomatoes, valueOf(5))
                        .addProductOrder(milk, valueOf(8))
                        .getTotalPrice());
    }
}
