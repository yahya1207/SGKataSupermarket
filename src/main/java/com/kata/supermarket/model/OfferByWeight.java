package com.kata.supermarket.model;

import com.kata.supermarket.type.WeightUnity;

public class OfferByWeight extends Offer {
    private WeightUnity unity;

    public OfferByWeight(int offerAmount, WeightUnity unity, int offerPrice) {
        super(offerAmount,offerPrice);
        this.unity = unity;
    }

    public WeightUnity getUnity() {
        return unity;
    }

}
