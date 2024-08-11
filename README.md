# Shopping Cart

## Overview
This is a simple command line application simulating a shopping cart. 
Program prompts user to type in a product name (single letter string .e.g "A", "B" etc). 
User's input is checked against available stock of products and if it is in stock it will be added to the current cart.
There are discounts available for some products and these discount prices require certain number of products to bought to qualify for discount.
If in the current cart there is a product that qualifies the discount it will be applied automatically and reflected in the cart summary.
If User types "exit" program prints cart summary including net total, total discount and total after discount and finally program 
prints a thank you message to the user before exiting.

## Technologies used
- Java
- Maven
- JUnit

## Requirements
- JDK 8+
-  Maven

## Running the program
```bash
git clone https://github.com/iamjakhtar/shopping-cart-v1.git

cd shopping-cart-v1

mvn clean install

java -cp target/shopping-cart-v1-1.0-SNAPSHOT.jar com.jakhtar.Main

mvn test
```
## Contributors
1. Jamil Akhtar
