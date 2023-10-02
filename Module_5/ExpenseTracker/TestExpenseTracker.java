/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.io.IOException; // Import the IOException class.
import java.time.LocalDateTime; // Import the LocalDateTime class.
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class.
import java.util.ArrayList; // Import the ArrayList class.
import java.util.Scanner; // Import the Scanner class.

public class TestExpenseTracker {

    private static boolean keepGoing = true; // Boolean to set if user wishes to continue or not.

    /**
     * Public void method used to display the menu.
     * @return none.
     */
    public static String menu() {
        return "\n  MENU OPTIONS\n    1. View Transactions\n    2. Add Transactions\n    3. View Expense\n\n  Please choose an option: ";
    } // end menu

    /**
     * A static void method which is used to test the Transaction, TransactionIO, and ValidatorIO classes.
     * @return none.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);  // Create a Scanner object to handle user inputs.

        System.out.println("  Welcome to the Expense Tracker");
        
        /** A while loop to control whether the user wants to continue. */
        while (keepGoing) {
            
            int input = ValidatorIO.getInt(sc, menu()); // Accept input from user and set as an Int.
            
            /** if statement to determine the desired user inputted transaction. */
            if (input == 1) { // View all transactions.
                ArrayList<Transaction> trans = TransactionIO.findAll(); // Get a list of transactions from expenses.txt.

                System.out.println("\n  MONTHLY EXPENSES\n");

                /** Loop through retrieved transactions and display them using the transaction's toString method. */
                for (Transaction transaction :trans) {
                    System.out.println(transaction.toString() + "\n");
                } // end for

            } else if (input == 2) { // Add new transactions.
                String c = "y"; // Set variable to track if the user wants to continue and default to y (yes).
                ArrayList<Transaction> transactions = new ArrayList<>(); // Create arraylist of transactions to store added transactions.

                while (c.equalsIgnoreCase("y")) { // Continue until user inputs anything but 'y'.
                    String description = ValidatorIO.getString(sc, "\n  Enter the description: "); // Accept user input via validator.
                    double amount = ValidatorIO.getDouble(sc, "  Enter the amount: "); // Accept user input via validator.

                    LocalDateTime currentDate = LocalDateTime.now(); // Set current date to be formatted as a LocalDateTime object.
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); // Set desired format as a DateTimeFormatter object.
                    Transaction transaction = new Transaction(currentDate.format(formatter), description, amount); // Create new transaction object.

                    transactions.add(transaction); // Add user inputted transaction.

                    c = ValidatorIO.getString(sc, "\n  Add another transaction? (y/n): "); // Accept user input via validator.
                } // end while

                /** Use a try catch for file writing operation. */
                try {
                    TransactionIO.bulkInsert(transactions); // Add transactions to expenses.txt.
                } catch (IOException e) {
                    System.out.println("\n  Exception: " + e.getMessage()); // Output error if encountered.
                } // end try/catch
            } else if (input == 3) { // View total amount of expenses from expenses.txt.
                ArrayList<Transaction> transactions = TransactionIO.findAll(); // Get a list of transactions from expenses.txt.
                Double monthlyExpense = 0.0; // Initialize monthlyExpense with default so compiler is happy.

                /** Loop through returned transactions and total the amount. */
                for (Transaction transaction : transactions) {
                    monthlyExpense += transaction.getAmount(); // Use += to iteratively add to total monthly expense.
                } // end for

                System.out.printf("\n  Your total monthly expense is $%,6.2f\n\n", monthlyExpense); // Print total to console.
            } // end if

            System.out.print("  Continue? (y/n): ");
            String userContinue = sc.nextLine(); // Accept input from user and set as a String.
            
            /** if statement to determine if the while loop should end based on userContinue value. */
            if (userContinue.equals("n")) {
                keepGoing = false; // If the user inputs "n", set keepGoing to false to exit the loop.
            } // end if
        } // end while

        sc.close(); // Close the scanner to prevent potentially memory leaks.
        System.out.println("\n  Program terminated by the user..."); // One only reaches this after a user enters "n" above. 
    } // end main

} // end TestExpenseTracker
