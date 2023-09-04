/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/ 

public class TestFanApp {
    public static void main(String[] args) {
        Fan defaultFan = new Fan(); // Create a fan object with the default values set.
        Fan customFan = new Fan(Fan.MEDIUM, true, 8.0, "Blue"); // Create a fan object with custom values set.

        System.out.println(defaultFan.toString()); // Print the defaultFan toString to the console.
        System.out.println(customFan.toString()); // Print the customFan toString to the console.
    } // end main
} // end TestFanApp
