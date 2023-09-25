/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Product {

    private String code; // Sets the code of the product.
    private String description; // Sets the description of the product.
    private Double price; // Sets the price of the product.

    /** Getters */
    public String getCode() {
        return code;
    } // end getCode

    public String getDescription() {
        return description;
    } // end getDescription

    public Double getPrice() {
        return price;
    } // end getPrice

    /** Setters */
    public void setCode(String code) {
        this.code = code;
    } // end setCode

    public void setDescription(String description) {
        this.description = description;
    } // end setDescription

    public void setPrice(double price) {
        this.price = price;
    } // end setPrice
    
    /**
     * Constructor which is used to create a Product object with the default values set.
     * @return none.
     */
    Product() {
        code = "";
        description = "";
        price = 0.0;
    } // end Product

    /**
     * Method which is used to override the Product object's toString.
     * @return a String of product details.
     */
    public String toString() {
        return String.format("  Product code: " + code + "\n  Description: " + description + "\n  Price: $%,6.2f", price);
    } // end toString

} // end Product
