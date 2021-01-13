package com.kata.supermarket.model;

public class Offer {
    private int offerAmount;
    private int offerPrice;

    public Offer(int offerAmount, int offerPrice) {
        this.offerAmount = offerAmount;
        this.offerPrice = offerPrice;
    }

    public int getOfferAmount() {
        return offerAmount;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

}
