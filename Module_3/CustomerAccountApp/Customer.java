/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Customer {

    private String name; // Sets the name of the customer.
    private String address; // Sets the address of the customer.
    private String city; // Sets the city of the customer.
    private String zip; // Sets the zip of the customer.

    /** Getters */
    public String getName() {
        return name;
    } // end getName

    public String getAddress() {
        return address;
    } // end getAddress

    public String getCity() {
        return city;
    } // end getCity

    public String getZip() {
        return zip;
    } // end getZip
    
    /**
     * Constructor which is used to create a customer object with the default values set.
     * @return none.
     */
    Customer() {
        name = "Jon Doe";
        address = "123 Bellevue Way";
        city = "Bellevue";
        zip = "68123";
    } // end Customer

    /**
     * Constructor with four arguments, which are used to create a Customer object.
     * @param name String 
     * @param address String
     * @param city String
     * @param zip String
     * @return none.
     */
    Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    } // end Customer

    /**
     * Method which is used to override the Customer object's toString.
     * @return a String of customer details.
     */
    public String toString() {
        return "  --Customer Details--\n  Name: " + name + "\n  Address: " + address + "\n  City: " + city + "\n  Zip: " + zip;
    } // end toString

} // end Customer
