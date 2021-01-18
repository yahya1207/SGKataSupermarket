package com.kata.supermarket;

import com.kata.supermarket.model.Offer;
import com.kata.supermarket.model.Product;
import com.kata.supermarket.repository.IOfferRepository;
import com.kata.supermarket.repository.OfferRepository;
import com.kata.supermarket.service.OrderCalculator;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //Available products
        Product tomatoes = new Product("tomatoes", new BigDecimal(1.99));
        Product milk = new Product("milk Candia", new BigDecimal(1.2));

        //Available offers
        Offer tomatoesOffer = new Offer(BigDecimal.valueOf(3), BigDecimal.valueOf(5.5));
        Offer milkOffer = new Offer(BigDecimal.valueOf(6), BigDecimal.valueOf(5));

        IOfferRepository offerRepository = OfferRepository.getInstance();
        offerRepository.addOffer(tomatoes, tomatoesOffer);
        offerRepository.addOffer(milk, milkOffer);

        //place an order
        OrderCalculator clientOrder = new OrderCalculator();

        BigDecimal totalPrice = clientOrder.addProductOrder(tomatoes, BigDecimal.valueOf(5))
                .addProductOrder(milk, BigDecimal.valueOf(11))
                .getTotalPrice();


        System.out.println("Le total = " + totalPrice);
    }
}
