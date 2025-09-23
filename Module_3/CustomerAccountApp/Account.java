package Module_3.CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Account class represents a simple bank account.
 * It maintains a balance and provides methods for deposit,
 * withdrawal, displaying a menu, and showing transaction dates.
 * @author Suresh Sripathi Rao
 * @version 1.0
 * Assignment 3.1
 */
public class Account {
    /** The balance of the account (default is 200) */
    private double balance = 200.00;

    /**
     * Returns the current account balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a given amount into the account.
     *
     * @param amt the amount to deposit
     */
    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
        }
    }

    /**
     * Withdraws a given amount if sufficient funds exist.
     *
     * @param amt the amount to withdraw
     */
    public void withdraw(double amt) {
        if (balance >= amt && amt > 0) {
            balance -= amt;
        } else {
            System.out.println("  Error: Insufficient funds.");
        }
    }

    /**
     * Displays the account menu with available options.
     */
    public void displayMenu() {
        System.out.println("\n  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w> for withdraw");
        System.out.println("  Enter <B/b> for balance");
    }

    /**
     * Returns the current transaction date formatted as MM-dd-yyyy.
     *
     * @return the formatted date string
     */
    public String getTransactionDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(date);
    }
}
