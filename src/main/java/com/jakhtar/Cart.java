package com.jakhtar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private List<Product> products;
    private Map<Character, Product> availableProducts = new HashMap<>();
    public Cart(List<Product> products) {
        this.products = products;
        this.addStock();
    }

    public void addToCart(char productName) { 
        Product p = this.availableProducts.get(productName);
        this.products.add(p);
    }

    public void printCart() {
        this.products.stream().forEach(p -> System.out.println(p));
    }

    public Map<Character, Product> getAvailableProducts() {
        return this.availableProducts;
    }

    public void addStock() {
        this.availableProducts.put('A', new Product('A', 0.50));
        this.availableProducts.put('B', new Product('B', 0.30));
        this.availableProducts.put('C', new Product('C', 0.20));
        this.availableProducts.put('D', new Product('D', 0.15));
    }
}
