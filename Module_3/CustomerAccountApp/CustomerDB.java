/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class CustomerDB {
    
    /**
     * Public static method with one argument, which is used to create a Customer object based on id value.
     * @param id int 
     * @return a Customer object based on id provided.
     */
    public static Customer getCustomer(int id) {
        /** if statement to control which customer account is instantiated. */
        if (id == 1007) {
            Customer customer = new Customer("John Wick", "98 Sunshine Rd", "Taunton", "02347"); // Instantiate Customer object with unique fields.
            return customer; // return Customer object to caller.
        } else if (id == 1008) {
            Customer customer = new Customer("Jill Smith", "790 Patty Dr", "Johnson City", "37601"); // Instantiate Customer object with unique fields.
            return customer; // return Customer object to caller.
        } else if (id == 1009) {
            Customer customer = new Customer("Dwayne Johnson", "401 Unknown Ln", "Waikiki", "96815"); // Instantiate Customer object with unique fields.
            return customer; // return Customer object to caller.
        } else {
            Customer customer = new Customer(); // Instantiate Customer object with default values.
            return customer; // return Customer object to caller.
        } // end if
    } // end getCustomer

} // end CustomerDB
