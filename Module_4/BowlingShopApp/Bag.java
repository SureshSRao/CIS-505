package Module_4.BowlingShopApp;

/**
 * Bag represents a bowling bag product.
 * Extends Product and adds the type property.
 * Assignment 4.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class Bag extends Product {
    /** Type of the bowling bag (single, double, triple) */
    private String type = "";

    /** Default constructor */
    public Bag() {}

    /**
     * Returns the bag type.
     * @return type of the bag
     */
    public String getType() { return type; }

    /**
     * Sets the bag type.
     * @param type the type to assign
     */
    public void setType(String type) { this.type = type; }

    /**
     * Returns product details plus bag-specific information.
     * @return formatted string
     */
    @Override
    public String toString() {
        return super.toString() + "\n  Type: " + type;
    }
}

