/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Composer {

    private int id; // Sets the id of a Composer.
    private String name; // Sets the name of a Composer.
    private String genre; // Sets the genre of a Composer.

    /** Getters */
    public int getId() {
        return id;
    } // end getId

    public String getName() {
        return name;
    } // end getName

    public String getGenre() {
        return genre;
    } // end getGenre
    
    /**
     * Constructor which is used to create a Composer object with the default values set.
     * @return none.
     */
    Composer() {
        id = 0;
        name = "";
        genre = "";
    } // end Composer

    /**
     * Constructor with three arguments, which are used to create a Composer object.
     * @param id int 
     * @param name String
     * @param genre String
     * @return none.
     */
    Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    } // end Composer

    /**
     * Method which is used to override the Composer object's toString.
     * @return a String of Composer details.
     */
    public String toString() {
        return "  Id: " + id + "\n  Name: " + name + "\n  Genre: " + genre;
    } // end toString

} // end Composer
