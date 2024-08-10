package com.jakhtar;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Cart cart;

    public UserInterface(Scanner scaner, Cart cart) {
        this.scanner = scaner;
        this.cart = cart;
    }

    public void scanItems() {

        while (true) {
            System.out.println("Enter a product name: ");
            
            try {
                String userInput = this.scanner.nextLine().trim().toUpperCase();
                
                if (userInput.equals("EXIT")) {
                    this.cart.printCart();
                    break;
                }
                char productName = userInput.charAt(0);
                if (userInput == null || !this.cart.getAvailableProducts().containsKey(productName)) {
                    throw new IllegalArgumentException("Invalid product name, try again");
                }
                
                this.cart.addToCart(productName);
                this.cart.printCart();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
