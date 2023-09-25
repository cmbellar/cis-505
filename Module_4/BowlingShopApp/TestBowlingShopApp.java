/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.Scanner; // Import the Scanner class to handle user input.

public class TestBowlingShopApp {

    private static boolean keepGoing = true; // Boolean to set if user wishes to continue or not.

    /**
     * Public void method used to display the product menu.
     * @return none.
     */
    public static void displayMenu() {
        System.out.print("\n  MENU OPTIONS\n    1. <b> Bowling Balls\n    2. <a> Bowling Bags\n    3. <s> Bowling Shoes\n    4. <x> To exit\n\n  Please choose an option>: ");
    } // end displayMenu

    /**
     * A static void method which is used to test the Product, Ball, Bag, Shoe, GenericQueue, and ProductDB classes.
     * @return none.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to handle user inputs.

        System.out.println("  Welcome to the Bowling Shop");
        
        /** A while loop to control whether the user wants to continue. */
        while (keepGoing) {
            displayMenu(); // Display the account objects menu.
            
            String productOption = scanner.nextLine(); // Accept input from user and set as a String.
            
            /** if statement to determine the user selection. */
            if (productOption.equalsIgnoreCase("x")) {
                keepGoing = false; // If the user inputs "x", set keepGoing to false to exit the loop.
            } else {
                System.out.println("\n  --Product Listing--");
                GenericQueue<Product> products = ProductDB.getProducts(productOption); // Instantiate a GenericQueue<Product> populated based on user input.
                while (products.size() > 0) {
                    products.dequeue(); // While the products size is greater than 0, display the contents of each object and dequeue it.
                }
            } // end if
        } // end loop

        scanner.close(); // Close the scanner to prevent potentially memory leaks.
        System.out.println("\n  End of line..."); // One only reaches this after a user enters "x" above. 
    } // end main

} // end TestBowlingShopApp
