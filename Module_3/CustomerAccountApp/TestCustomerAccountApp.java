/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.Scanner; // Import the Scanner class to handle user input.

public class TestCustomerAccountApp {

    private static boolean keepGoing = true; // Boolean to set if user wishes to continue or not.

    /**
     * A static void method which is used to test the Account, Customer, and CustomerDB classes.
     * @return none.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to handle user inputs.

        System.out.println("  Welcome to the Customer Account App");
        System.out.println("\n  Enter a customer id:");
        System.out.print("    ex: 1007, 1008, 1009>: ");

        /** 
         * Accept customer ID input from user and set as an int.
         * Note: I used parseInt to preserve the cursor position, otherwise this is skipped over.
         */
        int customerId = Integer.parseInt(scanner.nextLine());

        Customer customer = CustomerDB.getCustomer(customerId); // Instantiate customer object based on user inputted id.
        Account account = new Account(); // Instantiate a new account object.
        
        /**
        * A while loop to control whether the user wants to continue after managing their account.
        * Note: print is used instead of println for lines that require user inputs and printf for displaying currency.
        */
        while (keepGoing) {
            account.displayMenu(); // Display the account objects menu.
            
            String accountOption = scanner.nextLine(); // Accept input from user and set as a String.
            
            /** if statement to determine the desired user inputted transaction. */
            if (accountOption.equalsIgnoreCase("d")) {
                System.out.print("\n  Enter deposit amount: ");
                account.deposit(scanner.nextDouble()); // Deposit amount provided by user input.
            } else if (accountOption.equalsIgnoreCase("w")) {
                System.out.print("\n  Enter withdraw amount: ");
                account.withdraw(scanner.nextDouble()); // Withdraw amount provided by user input.
            } else if (accountOption.equalsIgnoreCase("b")) {
                System.out.printf("\n  Account balance: $%,6.2f\n", account.getBalance()); // Display user's account balance.
            } else {
                System.out.println("\n  Error: Invalid option"); // Display error to user because a valid option wasn't provided.
            } // end if
            
            System.out.print("\n  Continue? (y/n): ");
            String userContinue = scanner.nextLine(); // Accept input from user and set as a String.

            /** if statement to determine if the while loop should end based on userContinue value. */
            if (userContinue.equals("n")) {
                keepGoing = false; // If the user inputs "n", set keepGoing to false to exit the loop.
                System.out.printf("\n" + customer.toString() + "\n\n  Balance as of " + account.getTransactionDate() 
                    + " is $%,6.2f \n\n  End of line...", account.getBalance()); // Display the final details to user prior to exit.
                scanner.close(); // Close the scanner to prevent potential memory leaks.
            } // end if
        } // end loop
    } // end main

} // end TestCustomerAccountApp
