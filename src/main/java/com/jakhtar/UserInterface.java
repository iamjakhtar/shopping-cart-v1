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
                    double change = this.processPayment(scanner, cart);
                    this.cart.printCheckoutSummary(change);

                    break;
                }
                char productName = userInput.charAt(0);
                boolean isProductInStock = this.cart.getAvailableProducts().containsKey(productName);

                if (userInput == null || !isProductInStock) {
                    throw new InvalidProductException("Invalid product name, try again");
                }

                this.cart.addToCart(productName);
                this.cart.printCart();

            } catch (InvalidProductException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (this.scanner != null) {
            this.scanner.close();
        }
    }

    public double processPayment(Scanner scanner, Cart cart) {
        double amount = 0.0;
        while (true) {
            System.out.println("Please enter amount to pay:");
            amount = Double.parseDouble(this.scanner.nextLine().trim());
            if (!this.cart.isAmountValid(amount)) {
                System.out.println("Not correct amount, try again");
                continue;
            }
            break;
        }
        return this.cart.payNow(amount);

    }
}
