package Module_8;

/**
 * Assignment 8.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 * 
 * FinanceCalculator provides a static method to compute the future value
 * based on a fixed monthly payment, an annual interest rate, and a duration in years.
 */
public class FinanceCalculator {

  /** Number of months in a year. */
  private static final int MONTHS_IN_YEAR = 12;

  /**
   * Calculates the future value using:
   * months = years * MONTHS_IN_YEAR
   * interestRate = (1 + rate / 100)     // Exhibit A
   * presentValue = monthlyPayment * months
   * futureValue = presentValue * Math.pow(interestRate, months)   // Exhibit B
   *
   * @param monthlyPayment the monthly payment amount
   * @param rate the ANNUAL interest rate in percent (e.g., 6.5 for 6.5%)
   * @param years the number of years
   * @return calculated future value
   */
  public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
    int months = years * MONTHS_IN_YEAR;
    double interestRate = (1 + rate / 100.0);
    double presentValue = monthlyPayment * months;
    double futureValue = presentValue * Math.pow(interestRate, months);
    return futureValue;
  }
}

