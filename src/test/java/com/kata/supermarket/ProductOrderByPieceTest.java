package com.kata.supermarket;

import com.kata.supermarket.model.IProductOrder;
import com.kata.supermarket.model.Product;
import com.kata.supermarket.model.ProductOrderByPiece;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ProductOrderByPieceTest {

    @Test
    public void testOrderWithoutOffer() {
        Product milk = new Product("Candia milk", 1);
        IProductOrder productOrder = new ProductOrderByPiece(milk, 3);
        Assert.assertEquals(3d, productOrder.calculateProductOrderPrice());
    }
}
