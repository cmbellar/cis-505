/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.time.LocalDateTime; // Import the LocalDateTime class.
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class.

public class Transaction {

    private String date; // Sets the date of a transaction.
    private String description; // Sets the description of a transaction.
    private Double amount; // Sets the amount of a transaction.

    /** Getters */
    public String getDate() {
        return date;
    } // end getDate

    public String getDescription() {
        return description;
    } // end getDescription

    public Double getAmount() {
        return amount;
    } // end getAmount

    /** Setters */
    public void setDate(String date) {
        this.date = date;
    } // end setDate

    public void setDescription(String description) {
        this.description = description;
    } // end setDescription

    public void setAmount(double amount) {
        this.amount = amount;
    } // end setAmount
    
    /**
     * Constructor which is used to create a Transaction object with the default values set.
     * Note - Used LocalDateTime and DateTimeFormatter to set default date to MM-dd-yyyy.
     * @return none.
     */
    Transaction() {
        LocalDateTime currentDate = LocalDateTime.now(); // Set current date to be formatted as a LocalDateTime object.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); // Set desired format as a DateTimeFormatter object.
        date = currentDate.format(formatter); // Set formatted LocalDateTime object as date String.
        description = "";
        amount = 0.0;
    } // end Transaction

    /**
     * Constructor with three arguments, which are used to create a Transaction object.
     * @param date String 
     * @param description String
     * @param amount Double
     * @return none.
     */
    Transaction(String date, String description, Double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    } // end Transaction

    /**
     * Method which is used to override the Transaction object's toString.
     * @return a String of Transaction details.
     */
    public String toString() {
        return String.format("  Date: " + date + "\n  Description: " + description + "\n  Amount: $%,6.2f", amount);
    } // end toString

} // end Transaction
