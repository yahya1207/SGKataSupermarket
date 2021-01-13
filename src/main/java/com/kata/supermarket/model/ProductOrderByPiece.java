package com.kata.supermarket.model;

public class ProductOrderByPiece implements IProductOrder {

    private Product product;
    private int orderAmount;
    private Offer offer;

    public ProductOrderByPiece(Product product, int orderAmount) {
        this.product = product;
        this.orderAmount = orderAmount;
    }

    public ProductOrderByPiece(Product product, int orderAmount, Offer offer) {
        this(product, orderAmount);
        this.offer = offer;
    }

    @Override
    public float calculateProductOrderPrice() {
        if (offer == null) {
            return product.getInitialPrice() * orderAmount;
        }

        int offerAmount = offer.getOfferAmount();
        int totalPrice = (orderAmount / offerAmount) * offer.getOfferPrice();
        // if the buying amount is not a multiple of offer amount so the rest's priced will be the product's unit price
        if (orderAmount % offerAmount != 0) {
            totalPrice += (orderAmount % offerAmount) * product.getInitialPrice();
        }
        System.out.println(product.getName() + "=" + totalPrice);
        return totalPrice;
    }
}
