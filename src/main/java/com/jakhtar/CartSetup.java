package com.jakhtar;

import java.util.HashMap;
import java.util.Map;

public class CartSetup {

    //Initial discounts
    public static Map<Character, Discount> addDiscounts() {
        Map<Character, Discount> discounts = new HashMap<>();
        discounts.put('A', new Discount('A', 3, 1.30));
        discounts.put('B', new Discount('B', 2, 0.45));
        //you can add more discounts here...
        return discounts;
    }

    //Stock of products to choose from
    public static Map<Character, Product> addStock() {
        Map<Character, Product> stock = new HashMap<>();
        stock.put('A', new Product('A', 0.50));
        stock.put('B', new Product('B', 0.30));
        stock.put('C', new Product('C', 0.20));
        stock.put('D', new Product('D', 0.15));
        //you can add more products here...
        return stock;
    }
    
}
