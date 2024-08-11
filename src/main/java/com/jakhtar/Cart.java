package com.jakhtar;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Cart {
    private List<Product> products;
    private Map<Character, Discount> discounts;
    private Map<Character, Product> availableProducts;
    private double cartTotal = 0.0;
    private double totalDiscount = 0.0;

    public Cart(List<Product> products, Map<Character, Product> availableProducts, Map<Character, Discount> discounts) {
        this.products = products;
        this.availableProducts = availableProducts;
        this.discounts = discounts;
    }

    public void addToCart(char productName) { 
        Product p = this.availableProducts.get(productName);
        this.products.add(p);
        cartTotal = this.getCartTotal();
        
        if (this.isEligibleForDiscount(p)) {
            totalDiscount = this.getTotalDiscount();
        }
    }

    public Map<Character, Product> getAvailableProducts() {
        return this.availableProducts;
    }

    private List<Product> getAllProductsByName(char productName) {
        return this.products.stream().filter(p -> p.getName() == productName).toList();
    }

    private double getProductTotal(Product product) {
        List<Product> products = this.getAllProductsByName(product.getName());
        double productTotal = products.size() * product.getUnitPrice();
        return productTotal;
    }

    private Optional<Discount> findDiscountByProductName(char productName) {
        return Optional.ofNullable(this.discounts.get(productName));
    }

    private double calculateProductDiscount(Product product) {
        double total = 0.0;
        int productCount = this.getAllProductsByName(product.getName()).size();
        Optional<Discount> optDiscount = this.findDiscountByProductName(product.getName());

        if (optDiscount != null) {
            Discount discount = optDiscount.get();
            total += (productCount / discount.getRequiredQty()) * discount.getDiscountedPrice();
            total += (productCount % discount.getRequiredQty()) * product.getUnitPrice();
        }
        return (this.getProductTotal(product) - total);
    }

    public double getTotalDiscount() {
        Product product = this.products.get(this.products.size() - 1);
        double productDiscount = this.calculateProductDiscount(product);

        return totalDiscount + productDiscount;
    }

    private boolean isEligibleForDiscount(Product p) {
        char productName = p.getName();
        if (this.discounts.containsKey(productName)) {
            Optional<Discount> optDiscount = this.findDiscountByProductName(productName);

            if (optDiscount != null) {
                Discount d = optDiscount.get();
                int productCount = this.getAllProductsByName(productName).size();
                if (productCount % d.getRequiredQty() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public double getCartTotal() {
        return this.products.stream().mapToDouble(p -> p.getUnitPrice()).sum();
    }

    public double getCartTotalAfterDiscount() {
        return this.cartTotal - this.totalDiscount;
    }

    public void printCart() {
        CartPrinter.printCart(products, cartTotal, totalDiscount);
    }
}
