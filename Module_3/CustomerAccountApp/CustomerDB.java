package Module_3.CustomerAccountApp;

/**
 * The CustomerDB class simulates a small database
 * of Customer objects identified by an ID.
 * @author Suresh Sripathi Rao
 * @version 1.0
 * Assignment 3.1
 */
public class CustomerDB {

    /**
     * Returns a Customer object based on the provided ID.
     * Matches IDs 1007, 1008, or 1009 with predefined customers.
     * Returns a default Customer object if no match is found.
     *
     * @param id the customer number
     * @return a Customer object
     */
    public static Customer getCustomer(int id) {
        if (id == 1007) {
            return new Customer("Jennifer Patterson", "8422 Grover Ave", "Bellevue", "68123");
        } else if (id == 1008) {
            return new Customer("Mary Johnson", "456 Oak Ave", "Dallas", "75201");
        } else if (id == 1009) {
            return new Customer("David Brown", "789 Pine Rd", "Houston", "77001");
        } else {
            return new Customer(); // default
        }
    }
}

