package com.jakhtar;

public class Product {
    private char name;
    private double unitPrice;

    public Product(char name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public char getName() {
        return this.name;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    @Override
    public String toString() {
        return this.name + "\t\t" + this.unitPrice;
    }
}
