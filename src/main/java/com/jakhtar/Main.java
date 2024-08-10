package com.jakhtar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart(new ArrayList<Product>());
        UserInterface ui = new UserInterface(scanner, cart);
        ui.scanItems();
        // Map<Character, Product> products = new HashMap<>();

        // products.put('A', new Product('A', 0.50));
        // products.put('B', new Product('B', 0.30));
        // products.put('C', new Product('C', 0.20));
        // products.put('D', new Product('D', 0.15));

        // char p = scanner.nextLine().toUpperCase().trim().charAt(0);
        // System.out.println(products.get(p));
    }
}