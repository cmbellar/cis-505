/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Ball extends Product {

    private String color; // Sets the color of the ball.

    /** Getters */
    public String getColor() {
        return color;
    } // end getColor

    /** Setters */
    public void setColor(String color) {
        this.color = color;
    } // end setColor
    
    /**
     * Constructor which is used to create a Ball object with the default values set.
     * @return none.
     */
    Ball() {
        color = "";
    } // end Ball

    /**
     * Method which is used to override the Ball object's toString.
     * @return a String of Ball details.
     */
    public String toString() {
        return super.toString() + "\n  Color: " + color + "\n";
    } // end toString

} // end Ball
