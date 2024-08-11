package com.jakhtar;

import java.text.DecimalFormat;
import java.util.List;

public class CartPrinter {
    private static DecimalFormat formatter = new DecimalFormat("0.##");
    private static final String LINE_SEPARATOR = "-".repeat(24);
    
    public static  void printSeparator() {
        System.out.println(LINE_SEPARATOR);
    }

    public static  void printCartHeader() {
        printSeparator();
        System.out.println("-".repeat(4) + " Shopping  Cart " + "-".repeat(4));
        printSeparator();
        System.out.println("Product\t\t Price");
        printSeparator();
    }

    private static void printCartFooter(double cartTotal, double totalDiscount) {
        printSeparator();
        System.out.println("Net total:\t" + cartTotal);
        System.out.println("Discount:\t" + formatAmount(totalDiscount));
        System.out.println("Total:\t\t" + formatAmount(cartTotal - totalDiscount));
        printSeparator();
    }

    public static void printCart(List<Product> products, double cartTotal, double totalDiscount) {
        printCartHeader();
        products.stream().forEach(p -> System.out.println(p));
        printCartFooter(cartTotal, totalDiscount);
    }

    private static String formatAmount(double amount) {
        return formatter.format(amount);
    }
}
