/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by C. Bellar 2023
    Created to test jar file process.
*/ 
public class BellarJarTwo {

    /**
     * Method with two arguments, which are used to print Hello World along with the user's first and last name.
     * @param firstName String 
     * @param lastName String 
     * @return prints the results to the console window.
     */
    public static void sayHello(String firstName, String lastName) {
        System.out.printf("Hello World from %s %s", firstName, lastName);
    } // end sayHello

    public static void main(String[] args) {
        sayHello("Chris", "Bellar"); // Call the sayHello method and pass "Chris" and "Bellar" as values.
    } // end main
} // end BellarJarTwo