/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Bag extends Product {

    private String type; // Sets the type of the Bag.

    /** Getters */
    public String getType() {
        return type;
    } // end getType

    /** Setters */
    public void setType(String type) {
        this.type = type;
    } // end setType
    
    /**
     * Constructor which is used to create a Bag object with the default values set.
     * @return none.
     */
    Bag() {
        type = "";
    } // end Bag

    /**
     * Method which is used to override the Bag object's toString.
     * @return a String of Bag details.
     */
    public String toString() {
        return super.toString() + "\n  Type: " + type + "\n";
    } // end toString

} // end Bag
