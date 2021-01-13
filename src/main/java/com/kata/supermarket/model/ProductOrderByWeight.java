package com.kata.supermarket.model;

import com.kata.supermarket.converter.IWeightConverter;
import com.kata.supermarket.type.WeightUnity;

public class ProductOrderByWeight implements IProductOrder {

    private Product product;
    private int orderAmount;
    private WeightUnity orderUnity;
    private OfferByWeight offer;

    private IWeightConverter converter = new IWeightConverter() {}; // should implement a converter

    public ProductOrderByWeight(Product product, int orderAmount, WeightUnity orderUnity) {
        this.product = product;
        this.orderAmount = orderAmount;
        this.orderUnity = orderUnity;
    }
    public ProductOrderByWeight(Product product, int orderAmount, WeightUnity orderUnity, OfferByWeight offerByWeight) {
        this(product, orderAmount, orderUnity);
        this.offer = offerByWeight;
    }

    @Override
    public float calculateProductOrderPrice() {
        //if no offer
        if (offer == null) {
            return product.getInitialPrice() * orderAmount;
        }
        float unityConvertionRate = converter.getRate(offer.getUnity(), orderUnity);
        int offerAmount = offer.getOfferAmount();
        float total = offer.getOfferPrice() * (orderAmount / offerAmount);
        if (orderAmount % offerAmount != 0) {
            total += (orderAmount % offerAmount) * product.getInitialPrice();
        }
        return unityConvertionRate * total;
    }
}
