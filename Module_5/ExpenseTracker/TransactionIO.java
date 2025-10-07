package Module_5.ExpenseTracker;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles reading and writing transactions to a text file.
 * Assignment 5.1
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class TransactionIO {
  /** File name constant. */
  private static final String FILE_NAME = "Module_5//ExpenseTracker//expenses.txt";

  /** Backing file instance. */
  private static final File file = new File(FILE_NAME);

  /**
   * Writes a list of transactions to the expenses file (appending if it exists).
   * Each transaction is written as a single line: date|description|amount
   *
   * @param transactions list to persist
   * @throws IOException if file IO fails
   */
  public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
    PrintWriter output = null;
    try {
      if (file.exists()) {
        // append mode to preserve prior data
        output = new PrintWriter(new PrintStream(new FileOutputStream(file, true)));
      } else {
        output = new PrintWriter(FILE_NAME);
      }
      for (Transaction t : transactions) {
        output.print(t.getDate()); output.print("|");
        output.print(t.getDescription()); output.print("|");
        output.println(t.getAmount());
      }
    } finally {
      if (output != null) output.close();
    }
  }

  /**
   * Reads all transactions from the file and returns them as a list.
   *
   * @return list of transactions
   * @throws IOException if file IO fails
   */
  public static ArrayList<Transaction> findAll() throws IOException {
    ArrayList<Transaction> list = new ArrayList<>();
    if (!file.exists()) {
      return list;
    }
    Scanner input = new Scanner(file);
    while (input.hasNext()) {
      String line = input.nextLine();
      if (line.trim().isEmpty()) continue;
      String[] parts = line.split("\\|", -1);
      if (parts.length >= 3) {
        String date = parts[0];
        String desc = parts[1];
        double amt = 0.0;
        try {
          amt = Double.parseDouble(parts[2]);
        } catch (NumberFormatException ex) {
          // skip malformed amount line
          continue;
        }
        list.add(new Transaction(date, desc, amt));
      }
    }
    input.close();
    return list;
  }
}

