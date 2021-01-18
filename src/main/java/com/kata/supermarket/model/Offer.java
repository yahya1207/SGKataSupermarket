package com.kata.supermarket.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_DOWN;

public class Offer {
    private BigDecimal offerAmount;
    private BigDecimal offerPrice;

    public Offer(BigDecimal offerAmount, BigDecimal offerPrice) {
        if (offerAmount == null || ZERO.compareTo(offerAmount) >= 0) {
            throw new IllegalArgumentException("Offer amount should be greater than zero. Offer amount = " + offerAmount);
        }
        if (offerPrice == null || ZERO.compareTo(offerPrice) >= 0) {
            throw new IllegalArgumentException("Offer price should be greater than zero. Offer price = " + offerPrice);
        }
        this.offerAmount = offerAmount.setScale(2, HALF_DOWN);
        this.offerPrice = offerPrice.setScale(2, HALF_DOWN);
    }

    public BigDecimal getOfferAmount() {
        return offerAmount;
    }

    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

}
