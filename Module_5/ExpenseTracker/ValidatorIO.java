package Module_5.ExpenseTracker;

import java.util.Scanner;

/**
 * Utility class for validating user input from a Scanner.
 * Assignment 5.1
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class ValidatorIO {

  /**
   * Prompts for and returns an integer value.
   * Continues until a valid integer is provided.
   *
   * @param sc     scanner
   * @param prompt prompt to display
   * @return valid integer value
   */
  public static int getInt(Scanner sc, String prompt) {
    int input = 0;
    boolean isValid = false;
    while (!isValid) {
      System.out.print("  " + prompt);
      if (sc.hasNextInt()) {
        input = sc.nextInt();
        sc.nextLine(); // consume newline
        isValid = true;
      } else {
        System.out.println("  Error! Invalid integer value.");
        sc.nextLine(); // discard bad token
      }
    }
    return input;
  }

  /**
   * Prompts for and returns a double value.
   * Continues until a valid double is provided.
   *
   * @param sc     scanner
   * @param prompt prompt to display
   * @return valid double value
   */
  public static double getDouble(Scanner sc, String prompt) {
    double input = 0.0;
    boolean isValid = false;
    while (!isValid) {
      System.out.print("  " + prompt);
      if (sc.hasNextDouble()) {
        input = sc.nextDouble();
        sc.nextLine(); // consume newline
        isValid = true;
      } else {
        System.out.println("  Error! Invalid decimal value.");
        sc.nextLine(); // discard bad token
      }
    }
    return input;
  }

  /**
   * Prompts for and returns a single token String.
   * (If you want full-line input for descriptions, use nextLinePrompt.)
   *
   * @param sc     scanner
   * @param prompt prompt to display
   * @return string token
   */
  public static String getString(Scanner sc, String prompt) {
    System.out.print("  " + prompt);
    return sc.next();
  }

  /**
   * Helper for full-line String input (useful for descriptions).
   * @param sc     scanner
   * @param prompt prompt
   * @return entire line string
   */
  public static String getLine(Scanner sc, String prompt) {
    System.out.print("  " + prompt);
    return sc.nextLine();
  }
}

