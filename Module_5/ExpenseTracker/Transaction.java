package Module_5.ExpenseTracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a single expense transaction with a date, description, and amount.
 * Assignment 5.1
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class Transaction {
  /** The transaction date in MM-dd-yyyy format. Defaults to today's date. */
  private String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());

  /** The description for this transaction. */
  private String description = "";

  /** The amount for this transaction. */
  private double amount = 0.0;

  /** No-arg constructor: uses default field values. */
  public Transaction() { }

  /**
   * Full-arg constructor.
   * @param date        date in MM-dd-yyyy
   * @param description description text
   * @param amount      transaction amount
   */
  public Transaction(String date, String description, double amount) {
    this.date = date;
    this.description = description;
    this.amount = amount;
  }

  /** @return the date */
  public String getDate() { return date; }

  /** @param date the date to set (MM-dd-yyyy) */
  public void setDate(String date) { this.date = date; }

  /** @return the description */
  public String getDescription() { return description; }

  /** @param description the description to set */
  public void setDescription(String description) { this.description = description; }

  /** @return the amount */
  public double getAmount() { return amount; }

  /** @param amount the amount to set */
  public void setAmount(double amount) { this.amount = amount; }

  /**
   * Returns a multi-line string with each field on its own line.
   */
  @Override
  public String toString() {
    return "  Date: " + date + "\n"
         + "  Description: " + description + "\n"
         + String.format("  Amount: $%,6.2f", amount);
  }
}

