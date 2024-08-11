package com.jakhtar;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Cart {
    private List<Product> products;
    private Map<Character, Discount> discounts;
    private Map<Character, Product> availableProducts;
    private DecimalFormat formatter = new DecimalFormat("0.##");
    private double cartTotal = 0.0;
    private double totalDiscount = 0.0;
    private static final String LINE_SEPARATOR = "-".repeat(24);

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

    private double getTotalDiscount() {
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

    private double getCartTotal() {
        return this.products.stream().mapToDouble(p -> p.getUnitPrice()).sum();
    }

    private void printSeparator() {
        System.out.println(LINE_SEPARATOR);
    }

    private void printCartHeader() {
        this.printSeparator();
        System.out.println("-".repeat(4) + " Shopping  Cart " + "-".repeat(4));
        this.printSeparator();
        System.out.println("Product\t\t Price");
        this.printSeparator();
    }

    private void printCartFooter() {
        this.printSeparator();
        System.out.println("Net total:\t" + cartTotal);
        System.out.println("Discount:\t" + this.formatAmount(totalDiscount));
        System.out.println("Total:\t\t" + this.formatAmount(cartTotal - totalDiscount));
        this.printSeparator();
    }

    public void printCart() {
        this.printCartHeader();
        this.products.stream().forEach(p -> System.out.println(p));
        this.printCartFooter();
    }

    private String formatAmount(double amount) {
        return this.formatter.format(amount);
    }
}
