/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Shoe extends Product {

    private Double size; // Sets the size of the Shoe.

    /** Getters */
    public Double getSize() {
        return size;
    } // end getSize

    /** Setters */
    public void setSize(Double size) {
        this.size = size;
    } // end setSize
    
    /**
     * Constructor which is used to create a Shoe object with the default values set.
     * @return none.
     */
    Shoe() {
        size = 0.0;
    } // end Shoe

    /**
     * Method which is used to override the Shoe object's toString.
     * @return a String of Shoe details.
     */
    public String toString() {
        return super.toString() + "\n  Size: " + size + "\n";
    } // end toString

} // end Shoe
