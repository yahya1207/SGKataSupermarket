package com.kata.supermarket.repository;

import com.kata.supermarket.model.Offer;
import com.kata.supermarket.model.Product;

public interface IOfferRepository {

    void addOffer(Product product, Offer offer);

    Offer getOffer(Product product);

    void clearOffers();
}
