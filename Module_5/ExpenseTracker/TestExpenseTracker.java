package Module_5.ExpenseTracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Driver class for the Expense Tracker application.
 * Displays a menu, lists transactions, adds transactions, and totals expenses.
 * Assignment 5.1
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class TestExpenseTracker {

  /** Displays the main menu (with two-space indentation on each line). */
  public static void displayMenu() {
    System.out.println("  Welcome to the Expense Tracker\n");
    System.out.println("  MENU OPTIONS");
    System.out.println("    1. View Transactions");
    System.out.println("    2. Add Transactions");
    System.out.println("    3. View Expense\n");
  }

  public static void main(String[] args) {
    Locale.setDefault(Locale.US); // ensure '.' decimal and correct currency format
    Scanner sc = new Scanner(System.in);
    String again;

    do {
      System.out.println();
      displayMenu();
      System.out.print("  Please choose an option: ");
      String option = sc.nextLine().trim();

      switch (option) {
        case "1": // Show all
          try {
            ArrayList<Transaction> all = TransactionIO.findAll();
            if (all.isEmpty()) {
              System.out.println("  No transactions found.");
            } else {
              System.out.println("\n  MONTHLY EXPENSES \n");
              for (Transaction t : all) {
                System.out.println(t.toString());
                System.out.println(); // blank line between entries for readability
              }
            }
          } catch (IOException e) {
            System.out.println("  Error reading transactions.");
          }
          break;

        case "2": // Add transaction(s)
          try {
            boolean addMore = true;
            while (addMore) {
              // Use validators as per spec
              String date = new Transaction().getDate();
              String description = ValidatorIO.getLine(sc, "\n  Enter the description: ");
              double amount = ValidatorIO.getDouble(sc, "Enter the amount: ");

              ArrayList<Transaction> batch = new ArrayList<>();
              batch.add(new Transaction(date, description, amount));
              TransactionIO.bulkInsert(batch);

              System.out.print("\n  Add another transaction? (y/n): ");
              String yn = sc.nextLine().trim().toLowerCase();
              addMore = yn.startsWith("y");
              System.out.println();
            }
          } catch (IOException e) {
            System.out.println("  Error writing transactions.");
          }
          break;

        case "3": // Show total expenses
          try {
            ArrayList<Transaction> all = TransactionIO.findAll();
            double total = 0.0;
            for (Transaction t : all) {
              total += t.getAmount();
            }
            System.out.printf("\n  Your total monthly Expense is $%,6.2f%n", total);
            System.out.println();
          } catch (IOException e) {
            System.out.println("  Error reading transactions.");
          }
          break;

        default:
          System.out.println("  Error: Invalid Option.");
      }

      System.out.print("  Continue? (y/n): ");
      again = sc.nextLine().trim().toLowerCase();
    } while (again.startsWith("y"));

    System.out.println("\n  Program terminated by the user...");
    sc.close();
  }
}

