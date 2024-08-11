package com.jakhtar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProductTest {

    @ParameterizedTest
    @CsvSource({
        "A, 0.5",
        "B, 0.3",
        "C, 0.2",
        "D, 0.15"
    })
    public void testProductCreation(String productName, double price) {
        Product testProduct = new Product(productName.charAt(0), price);
        assertEquals(productName.charAt(0), testProduct.getName());
        assertEquals(price, testProduct.getUnitPrice());
    }
    
    @ParameterizedTest
    @CsvSource({
        "A, 0.5",
        "B, 0.3",
        "C, 0.2",
        "D, 0.15"
    })
    public void testProductToString(String productName, double price) {
        Product testProduct = new Product(productName.charAt(0), price);
        String toString = productName.charAt(0) + "\t\t" + price;
        assertEquals(toString, testProduct.toString());
    }
}