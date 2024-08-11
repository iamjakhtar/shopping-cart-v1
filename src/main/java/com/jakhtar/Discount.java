package com.jakhtar;

public class Discount {
    private char productName;
    private int requiredQty;
    private double discountedPrice;
    public Discount(char productName, int requiredQty, double discountedPrice) {
        this.productName = productName;
        this.requiredQty = requiredQty;
        this.discountedPrice = discountedPrice;
    }
    public char getProductName() {
        return productName;
    }
    public void setProductName(char productName) {
        this.productName = productName;
    }
    public int getRequiredQty() {
        return requiredQty;
    }
    public void setRequiredQty(int requiredQty) {
        this.requiredQty = requiredQty;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
    
}
