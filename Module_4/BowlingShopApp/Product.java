package Module_4.BowlingShopApp;

/**
 * The Product class is the abstract representation of a bowling shop product.
 * It stores common fields for all products such as code, description, and price.
 * Assignment 4.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class Product {
    /** Unique code for the product */
    private String code = "";

    /** Text description of the product */
    private String description = "";

    /** Price of the product */
    private double price = 0.0;

    /** Default constructor */
    public Product() {}

    /**
     * Returns the product code.
     * @return product code
     */
    public String getCode() { return code; }

    /**
     * Sets the product code.
     * @param code the code to assign
     */
    public void setCode(String code) { this.code = code; }

    /**
     * Returns the product description.
     * @return product description
     */
    public String getDescription() { return description; }

    /**
     * Sets the product description.
     * @param description the description to assign
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Returns the product price.
     * @return product price
     */
    public double getPrice() { return price; }

    /**
     * Sets the product price.
     * @param price the price to assign
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Returns a formatted string with product details.
     * @return formatted string with product info
     */
    @Override
    public String toString() {
        return "  Product Code: " + code + "\n"
             + "  Description: " + description + "\n"
             + String.format("  Price: $%,6.2f", price);
    }
}

