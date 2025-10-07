package Module_4.BowlingShopApp;

import java.util.Scanner;

/**
 * TestBowlingShopApp is the driver class that displays
 * a menu, accepts user input, and prints product details
 * by retrieving them from ProductDB.
 * Assignment 4.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class TestBowlingShopApp {

    /**
     * Displays the main menu with options.
     */
    public static void displayMenu() {
        System.out.println();
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. <b> Bowling Balls");
        System.out.println("    2. <a> Bowling Bags");
        System.out.println("    3. <s> Bowling Shoes");
        System.out.println("    4. <x> To Exit");
        System.out.println();
    }

    /**
     * Main method to run the bowling shop app.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        System.out.println("  Welcome to the Bowling Shop");

        do {
            displayMenu();
            System.out.print("  Please choose an option: ");
            choice = sc.nextLine();

            GenericQueue<Product> products = ProductDB.getProducts(choice);
            if(products.size() > 0){
                System.out.println();
                System.out.print("  --Product Listing--");
            }
            while (products.size() > 0) {
                Product p = products.dequeue();
                System.out.println();
                System.out.println(p.toString());
            }

        } while (!choice.equalsIgnoreCase("x"));

        System.out.println("  Exiting the program...");
        sc.close();
    }
}

