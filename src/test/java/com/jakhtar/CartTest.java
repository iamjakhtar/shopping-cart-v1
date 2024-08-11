package com.jakhtar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest {

    private Cart cart;
    private List<Product> products;
    private Map<Character, Discount> discounts;
    private Map<Character, Product> stock;

    @BeforeEach
    public void setUp() {
        this.products = new ArrayList<>();
        this.discounts = CartSetup.addDiscounts();
        this.stock = CartSetup.addStock();
        this.cart = new Cart(products, stock, discounts);
    }

    @Test 
    public void testCartIsEmpty() {
        assertEquals(0, products.size());
    }

    @Test
    public void testAddToCart() {
        this.cart.addToCart('A');
        this.cart.addToCart('B');
        assertEquals(2, products.size());
        assertEquals('A', products.get(0).getName());
        assertEquals('B', products.get(1).getName());
    }
    
    @Test
    public void testCartTotal() {
        this.cart.addToCart('A');
        this.cart.addToCart('B');
        assertEquals(0.80, cart.getCartTotal(), 0.01);
        this.cart.addToCart('C');
        assertEquals(1.00, cart.getCartTotal(), 0.01);
    }

    @Test 
    public void testCartDiscount() {
        this.cart.addToCart('A');
        this.cart.addToCart('A');
        this.cart.addToCart('A');
        assertEquals(1.50, cart.getCartTotal(), 0.01);
        assertEquals(1.30, cart.getCartTotalAfterDiscount());
    }
}
