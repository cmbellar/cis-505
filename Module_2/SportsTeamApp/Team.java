/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Team {

    private String[] players = new String[20]; // Sets the players assigned to the team. The default size is 20.
    private int playerCount = 0; // Sets the number of players on a team.
    private String teamName = ""; // Sets the name of the team.

    /** Getters */
    public String[] getPlayers() {
        return players;
    } // end getPlayers

    public int getPlayerCount() {
        return playerCount;
    } // end getPlayerCount

    public String getTeamName() {
        return teamName;
    } // end getTeamName

    /**
     * A public void method with one argument, which is used to add a player and increment the playerCount counter.
     * @param player String
     * @return none.
     */
    public void addPlayer(String player) {
        players[playerCount] = player; // Add the player to the players array using playerCount to determine the index location.
        playerCount++; // Increment the playerCount counter by one.
    } // end addPlayer
    
    /**
     * Constructor with one argument, which are used to create a team object.
     * @param teamName String
     * @return none.
     */
    Team(String teamName) {
        this.teamName = teamName;
    } // end Team

} // end Team
