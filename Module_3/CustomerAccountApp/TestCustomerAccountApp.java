package Module_3.CustomerAccountApp;

import java.util.Scanner;

/**
 * TestCustomerAccountApp is the driver program that
 * tests the Customer, CustomerDB, and Account classes.
 * It allows user input to simulate basic account operations.
 * @author Suresh Sripathi Rao
 * @version 1.0
 * Assignment 3.1
 */
public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("  Welcome to the Customer Account App \n");

        // Prompt for customer number
        System.out.print("  Enter a customer ID: \n");
         System.out.print("   ex: 1007, 1008, 1009>: ");
        int customerId = sc.nextInt();
        sc.nextLine(); // consume newline

        Customer customer = CustomerDB.getCustomer(customerId);
        Account account = new Account();

        char option;
        do {
            account.displayMenu();
            System.out.print("    Enter option>: ");
            option = sc.nextLine().toLowerCase().charAt(0);

            switch (option) {
                case 'd':
                    System.out.print("\n  Enter deposit amount: ");
                    double depositAmt = sc.nextDouble();
                    sc.nextLine();
                    account.deposit(depositAmt);
                    break;

                case 'w':
                    System.out.print("\n  Enter withdraw amount: ");
                    double withdrawAmt = sc.nextDouble();
                    sc.nextLine();
                    account.withdraw(withdrawAmt);
                    break;

                case 'b':
                    System.out.printf("\n  Account Balance: $%,6.2f%n", account.getBalance());
                    break;

                default:
                    System.out.println("\n  Error: Invalid Option.");
            }

          System.out.print("\n  Continue? (y/n): "); 
          option = sc.nextLine().toLowerCase().charAt(0); 

        } while (option != 'n');

        // Display customer info and balance
        System.out.println("\n  --Customer Details--");
        System.out.println(customer.toString());
        System.out.print("  Balance as of "+account.getTransactionDate());
        System.out.printf(" is $%,6.2f%n",account.getBalance());

        sc.close();
    }
}

