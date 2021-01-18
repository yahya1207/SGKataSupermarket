package com.kata.supermarket.service;

import com.kata.supermarket.model.Offer;
import com.kata.supermarket.model.Product;
import com.kata.supermarket.repository.IOfferRepository;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_FLOOR;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_DOWN;

public class ProductOrderService implements IProductOrderService {

    private IOfferRepository offerRepository;

    ProductOrderService(IOfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public BigDecimal getCalculatedPrice(Product product, BigDecimal orderAmount) {
        if (orderAmount == null || ZERO.compareTo(orderAmount) >= 0) {
            throw new IllegalArgumentException("Order amount should be greater than zero. Order amount = " + orderAmount);
        }

        Offer offer = offerRepository.getOffer(product);
        if (offer == null) {
            //No offer found
            return product.getInitialPrice().multiply(orderAmount);
        }
        return getCalculatedPriceWithOffer(orderAmount, offer, product.getInitialPrice());
    }

    private BigDecimal getCalculatedPriceWithOffer(BigDecimal orderAmount, Offer offer, BigDecimal initialPrice) {
        BigDecimal offerAmount = offer.getOfferAmount();
        BigDecimal totalPrice = offer.getOfferPrice()
                .multiply(orderAmount.divide(offerAmount, 0, ROUND_FLOOR));

        BigDecimal remainder = orderAmount.remainder(offerAmount)
                .setScale(0, HALF_DOWN);
        if (!remainder.equals(ZERO)) {
            return totalPrice.add(remainder.multiply(initialPrice));
        }
        return totalPrice;
    }
}
