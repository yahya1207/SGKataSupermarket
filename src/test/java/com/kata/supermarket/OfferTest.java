package com.kata.supermarket;

import com.kata.supermarket.model.Offer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.math.BigDecimal.valueOf;

@RunWith(JUnit4.class)
public class OfferTest {

    @Test(expected = IllegalArgumentException.class)
    public void testOfferWithAmountNull() {
        new Offer(valueOf(3), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOfferWithPriceNull() {
        new Offer(null, valueOf(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOfferWithAmountZero() {
        new Offer(valueOf(1), valueOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOfferWithPriceZero() {
        new Offer(valueOf(0), valueOf(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOfferWithAmountLessThanZero() {
        new Offer(valueOf(5), valueOf(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOfferWithPriceLessThanZero() {
        new Offer(valueOf(-1), valueOf(5));
    }

    @Test
    public void testOfferCreation() {
        new Offer(valueOf(5), valueOf(5));
    }
}
