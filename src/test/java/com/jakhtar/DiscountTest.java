package com.jakhtar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountTest {
    
    @ParameterizedTest
    @CsvSource({
        "A, 3, 1.3",
        "A, 3, 1.3"
        
    })
    public void testDiscountCreation(String name, int qty, double price) {
        Discount discount = new Discount(name.charAt(0), qty, price);
        assertEquals(name.charAt(0), discount.getProductName());
        assertEquals(qty, discount.getRequiredQty());
        assertEquals(price, discount.getDiscountedPrice());
    }
}
