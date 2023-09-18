/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.math.BigDecimal; // Import the BigDecimal class.
import java.time.LocalDateTime; // Import the LocalDateTime class.
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class.

public class Account {
    
    private Double balance = 200.00; // Sets the balance of the account.

     /** Getters */
     public Double getBalance() {
        return balance;
    } // end getBalance

    /**
     * Public void method with one argument, which is used to add to the current balance of the account object.
     * @param amt Double 
     * @return none.
     */
    public void deposit(Double amt) {
        balance = Double.sum(balance, amt); // Add amt value to the total balance.
    } // end deposit

    /**
     * Public void method with one argument, which is used to subtract from the current balance of the account object.
     * @param amt Double 
     * @return none.
     */
    public void withdraw(Double amt) {
        /** Compare the balance and amt to determine if subtraction should occur. */
        if (Double.compare(balance, amt) >= 0) {
            BigDecimal balanceBigDecimal = new BigDecimal(balance); // Convert balance to BigDecimal for subtraction.
            BigDecimal amtBigDecimal = new BigDecimal(amt); // Convert amt to BigDecimal for subtraction.
            balance = (balanceBigDecimal.subtract(amtBigDecimal)).doubleValue(); // Use BigDecimal to do subtraction and update balance as a Double.
        } // end if
    } // end withdraw

    /**
     * Public void method used to display the account menu.
     * @return none.
     */
    public void displayMenu() {
        System.out.print("\n  Account Menu\n  Enter <D/d> for deposit\n  Enter <W/w> for withdraw\n  Enter <B/b> for balance\n    Enter option>: ");
    } // end displayMenu

    /**
     * Public String method used to return a string representation of the current date.
     * @return String representation of MM-dd-yyyy.
     */
    public String getTransactionDate() {
        LocalDateTime currentDate = LocalDateTime.now(); // Set current date to be formatted as a LocalDateTime object.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); // Set desired format as a DateTimeFormatter object.
        return currentDate.format(formatter); // Return formatted LocalDateTime object as a String.
    } // end getTransactionDate

} // end Account
