/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/ 

public class Fan {
    /** 
     * Set the fan speeds to their integer values.
     * They are set to public so that other classes can reference them.
     * */
    public final static int STOPPED = 0;
    public final static int SLOW = 1;
    public final static int MEDIUM = 2;
    public final static int FAST = 3;

    private int speed; // Sets the speed of the fan.
    private boolean on; // Sets whether the fan is on or off.
    private double radius; // Sets the radius of the fan.
    private String color; // Sets the color of the fan.

    /** Getters */
    public int getSpeed() {
        return speed;
    } // end getSpeed

    public boolean getOn() {
        return on;
    } // end getOn
    
    public double getRadius() {
        return radius;
    } // end getRadius

    public String getColor() {
        return color;
    } // end getColor

    /** Setters */
    public void setSpeed(int speed) {
        this.speed = speed;
    } // end setSpeed

    public void setOn(boolean on) {
        this.on = on;
    } // end setOn

    public void setRadius(double radius) {
        this.radius = radius;
    } // end setRadius

    public void setColor(String color) {
        this.color = color;
    } // end setColor

    /**
     * Constructor which is used to create a fan object with the default values set.
     * @return none.
     */
    Fan() {
        speed = STOPPED;
        on = false;
        radius = 6;
        color = "white";
    } // end fan
    
    /**
     * Constructor with four arguments, which are used to create a fan object.
     * @param speed int 
     * @param on boolean
     * @param radius double
     * @param color String
     * @return none.
     */
    Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    } // end fan

    /**
     * Method which is used to override the fan object's toString.
     * @return a String of fan configuration details based on whether the fan is on or off.
     */
    public String toString() {
        if (on) {
            return "The fan speed is set to " + speed + " with a color of " + color + " with a radius of " + radius;
        } else {
            return "The fan is " + color + " with a radius of " + radius + " and the fan is off";
        }
    } // end toString

} // end fan
