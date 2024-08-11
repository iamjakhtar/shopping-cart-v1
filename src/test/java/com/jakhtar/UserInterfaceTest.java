package com.jakhtar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInterfaceTest {
    
    private Cart cart;
    private UserInterface ui;
   

    @BeforeEach 
    public void setInputOutput() {
        List<Product> products = new ArrayList<>();
        Map<Character, Product> stock =  CartSetup.addStock();
        Map<Character, Discount> discounts = CartSetup.addDiscounts();
        this.cart = new Cart(products, stock, discounts);
    }

    public String simulateUserInput(String userInput) {
        ByteArrayInputStream input = new ByteArrayInputStream((userInput + "\nEXIT").getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setIn(input);
        System.setOut(new PrintStream(output));

        Scanner scanner = new Scanner(System.in);
        this.ui = new UserInterface(scanner, cart);

        this.ui.scanItems();

        return output.toString();
    }

    @Test
    public void testExitUI() {
        String output = simulateUserInput("EXIT");

        String prompt = "Enter a product name or type 'exit' to end the program.";
        String exitMsg =    "Thank you for shopping.";

        assertTrue(output.contains(prompt));
        assertTrue(output.contains(exitMsg));
    }

    @Test
    public void testInvalidProductName() {
        String output = simulateUserInput("T");
        assertTrue(output.contains("Invalid product name, try again"));
    }

    @Test
    public void testValidProductAdded() {
        simulateUserInput("A");
        assertEquals(0.5, this.cart.getCartTotal(), 0.01);
    }

    @Test
    public void testEmptyProductName() {
        String output = simulateUserInput("");
        assertTrue(output.contains("You have not provided a product name."));
    }


}
