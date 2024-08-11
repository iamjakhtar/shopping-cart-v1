package com.jakhtar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        Map<Character, Product> stock = CartSetup.addStock();
        Map<Character, Discount> discounts = CartSetup.addDiscounts();
        Cart cart = new Cart(products, stock, discounts);
        UserInterface ui = new UserInterface(scanner, cart);
        ui.scanItems();
        
    }

}