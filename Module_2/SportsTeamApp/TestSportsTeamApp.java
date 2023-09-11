/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.Scanner;  // Import the Scanner class to handle user input.

public class TestSportsTeamApp {

    private static boolean keepGoing = true; // Boolean to set if user wishes to continue or not.
    
    /**
     * A static void method which is used to test the Team class.
     * @return none.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to handle user inputs.
        
        /**
        * A while loop to control whether the user wants to continue after adding a team and players.
        * Note - print is used instead of println for lines that require user inputs.
        */
        while (keepGoing) {
            System.out.println("  Welcome to the Sports Team App\n");
            System.out.print("  Enter a team name: ");
            String teamName = scanner.nextLine(); // Accept team name input from user and set as a String.

            Team team = new Team(teamName); // Instantiate a new team object and pass the constructor the teamName String.
            System.out.println("  Enter the players names:");
            System.out.print("    hint: use commas for multiple players; no spaces>: ");
            String players = scanner.nextLine(); // Accept a comma delimited players list input from user and set as a String.

            String[] playersArray = players.split("\\s*,\\s*"); // Split comma delimited players list into an array and use regex to remove spaces.
            
            /** for loop to iterate over playersArray and add each player to team object. */
            for (int i = 0; i < playersArray.length; i++) {
                team.addPlayer(playersArray[i]); // Add player to team object.
            }

            System.out.println("\n  --Team Summary--");
            System.out.println("  Number of players in team: " + team.getPlayerCount()); // Use getPlayerCount to get count of players on team.
            System.out.print("  Players on team: ");

            String[] teamPlayers = team.getPlayers(); // Instantiate String array of players on team.

            /** for loop to iterate over teamPlayers and print each player to console. */
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(teamPlayers[i] + ",");
            }
            
            System.out.print("\n\n  Continue? (y/n): ");
            String userContinue = scanner.nextLine(); // Accept input from user and set as a String.

            /** if statement to determine if the while loop should end based on userContinue value. */
            if (userContinue.equals("n")) {
                keepGoing = false; // If the user inputs "n", set keepGoing to false to exit the loop.
            }
        }

        scanner.close(); // Close the scanner to prevent potentially memory leaks.
        System.out.println("\n  End of line...");
    } // end main
} // end TestSportsTeamApp
