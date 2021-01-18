package com.kata.supermarket.repository;

import com.kata.supermarket.model.Offer;
import com.kata.supermarket.model.Product;

import java.util.HashMap;
import java.util.Map;

public class OfferRepository implements IOfferRepository {

    private static OfferRepository offerRepository;
    private Map<Product, Offer> productToOfferMap = new HashMap<>();

    public static OfferRepository getInstance() {
        if (offerRepository == null) {
            offerRepository = new OfferRepository();
        }
        return offerRepository;
    }

    private OfferRepository() {
    }

    @Override
    public void addOffer(Product product, Offer offer) {
        productToOfferMap.put(product, offer);
    }

    @Override
    public Offer getOffer(Product product) {
        return productToOfferMap.get(product);
    }

    @Override
    public void clearOffers() {
        productToOfferMap.clear();
    }
}
