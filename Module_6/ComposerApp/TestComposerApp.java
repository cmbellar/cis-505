/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.List; // Import the List class.
import java.util.Scanner; // Import the Scanner class.

public class TestComposerApp {

    private static boolean keepGoing = true; // Boolean to set if user wishes to continue or not.

    /**
     * A static void method which is used to test the Composer, ComposeDao, GenericDao, and MemComposerDao classes.
     * @return none.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // Create a Scanner object to handle user inputs.
        MemComposerDao memComposerDao = new MemComposerDao(); // Create a memComposerDao object to test with.

        System.out.println("  Welcome to the Composer App");
        
        /** A while loop to control whether the user wants to continue. */
        while (keepGoing) {

            System.out.print("\n  MENU OPTIONS\n    1. View Composers\n    2. Find Composer\n    3. Add Composer\n    4. Exit\n\n  Please choose an option: ");

            /** 
            * Accept user input from user and set as an int.
            * Note: I used parseInt to preserve the cursor position, otherwise this is skipped over.
            */
            int input = Integer.parseInt(sc.nextLine());
            
            /** if statement to determine the desired user inputted transaction. */
            if (input == 1) { // View all composers.
                List<Composer> composers = memComposerDao.findAll(); // Return a List of the current composers and set it to a variable.
                System.out.println("\n  --DISPLAYING COMPOSERS--");

                /** Loop through composers List and print. */
                for (int i = 0; i < composers.size(); i++) {
                    System.out.println(composers.get(i).toString() + "\n");
                }
            } else if (input == 2) { // Find a composer.
                System.out.print("\n  Enter an id: ");
                int id = Integer.parseInt(sc.nextLine()); // Accept id input from user and set as an int.

                System.out.println("\n  --DISPLAYING COMPOSER--\n" + memComposerDao.findBy(id).toString()); // Return a composer by id and print. 
            } else if (input == 3) { // Add a composer.
                System.out.print("\n  Enter an id: ");
                int id = Integer.parseInt(sc.nextLine()); // Accept id input from user and set as an int.

                System.out.print("  Enter a name: ");
                String name = sc.nextLine(); // Accept name input from user and set as a String.

                System.out.print("  Enter a genre: ");
                String genre = sc.nextLine(); // Accept genre input from user and set as a String.

                memComposerDao.insert(new Composer(id, name, genre));
            } else if (input == 4) { // Exit app.
                keepGoing = false; // If the user inputs 4, set keepGoing to false to exit the loop.
                sc.close(); // Close the scanner to prevent potentially memory leaks.
                System.out.println("\n  Program terminated by the user...");
            } // end if
        } // end while
    } // end main

} // end TestComposerApp
