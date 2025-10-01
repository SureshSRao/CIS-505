package Module_3.CustomerAccountApp;

/**
 * The Customer class represents a customer with
 * name, address, city, and zip code fields.
 * It provides constructors, accessors, and a toString method
 * for formatted output.
 * @author Suresh Sripathi Rao
 * @version 1.0
 * Assignment 3.1
 */
public class Customer {
    /** The name of the customer */
    private String name;

    /** The address of the customer */
    private String address;

    /** The city of the customer */
    private String city;

    /** The zip code of the customer */
    private String zip;

    /**
     * No-argument constructor that creates a default customer
     * with empty string fields.
     */
    public Customer() {
        this.name = "";
        this.address = "";
        this.city = "";
        this.zip = "";
    }

    /**
     * Constructor that initializes all customer fields.
     *
     * @param name    the customer's name
     * @param address the customer's address
     * @param city    the customer's city
     * @param zip     the customer's zip code
     */
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    /** @return the customer's name */
    public String getName() {
        return name;
    }

    /** @return the customer's address */
    public String getAddress() {
        return address;
    }

    /** @return the customer's city */
    public String getCity() {
        return city;
    }

    /** @return the customer's zip code */
    public String getZip() {
        return zip;
    }

    /**
     * Returns a string description of the customer with all fields
     * printed on separate lines.
     *
     * @return formatted string of customer details
     */
    @Override
    public String toString() {
        return "  Name: " + name + "\n"
             + "  Address: " + address + "\n"
             + "  City: " + city + "\n"
             + "  Zip: " + zip;
    }
}

