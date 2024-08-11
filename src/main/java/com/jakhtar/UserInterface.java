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
            System.out.println("Enter a product name or type 'exit' to end the program.");
            
            try {
                String userInput = this.scanner.nextLine().trim().toUpperCase();
                
                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("You have not provided a product name.");
                }
                if (userInput.equals("EXIT")) {
                    this.cart.printCart();
                    System.out.println("Thank you for shopping.");
                    break;
                }
                char productName = userInput.charAt(0);
                boolean isProductInStock = this.cart.getAvailableProducts().containsKey(productName);

                if (userInput == null || !isProductInStock) {
                    throw new IllegalArgumentException("Invalid product name, try again");
                }
                
                this.cart.addToCart(productName);
                this.cart.printCart();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (this.scanner != null) {
            this.scanner.close();
        }
    }
}
