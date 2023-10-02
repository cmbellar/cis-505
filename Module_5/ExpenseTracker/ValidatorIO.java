/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.Scanner; // Import the Scanner class to handle user input.

public class ValidatorIO {

    /**
     * Public static int method with two arguments, which is used to validate integer values.
     * @param sc Scanner
     * @param prompt String 
     * @return int.
     */
    public static int getInt(Scanner sc, String prompt) {

        int input = 0; // Instantiate an int to hold user input.
        boolean isValid = false; // Set boolean to track if user input is valid.

        /** while loop to prompt user and accept valid input. */
        while (!isValid) {
            System.out.print(prompt); // Display message passed to method.

            /** if statement to validate user inout and set it */
            if (sc.hasNextInt()) {
                input = sc.nextInt(); // Accept user input as integer.
                isValid = true;
            } else {
                System.out.print("\n  Error! Invalid integer value.\n"); // Inform user that inout is invalid.
            } // end if

            sc.nextLine();
        } // end while

        return input; // return user input as integer.

    } // end getInt

    /**
     * Public static Double method with two arguments, which is used to validate Double values.
     * @param sc Scanner
     * @param prompt String 
     * @return Double.
     */
    public static Double getDouble(Scanner sc, String prompt) {

        Double input = 0.0; // Instantiate a Double to hold user input.
        boolean isValid = false; // Set boolean to track if user input is valid.

        /** while loop to prompt user and accept valid input. */
        while (!isValid) {
            System.out.print(prompt); // Display message passed to method.

            /** if statement to validate user inout and set it */
            if (sc.hasNextDouble()) {
                input = sc.nextDouble(); // Accept user input as Double.
                isValid = true;
            } else {
                System.out.print("\n  Error! Invalid Double value.\n"); // Inform user that inout is invalid.
            } // end if

            sc.nextLine();
        } // end while

        return input; // return user input as Double.

    } // end getDouble

    /**
     * Public static String method with two arguments, which is used to prompt the user for String values.
     * @param sc Scanner
     * @param prompt String 
     * @return String.
     */
    public static String getString(Scanner sc, String prompt) {

        System.out.print(prompt); // Display message passed to method.

        return sc.next(); // return user input as String.

    } // end getString

} // end ValidatorIO
