package Module_4.BowlingShopApp;

/**
 * Shoe represents a bowling shoe product.
 * Extends Product and adds the size property.
 * Assignment 4.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class Shoe extends Product {
    /** Size of the bowling shoe */
    private double size = 0;

    /** Default constructor */
    public Shoe() {}

    /**
     * Returns the shoe size.
     * @return shoe size
     */
    public double getSize() { return size; }

    /**
     * Sets the shoe size.
     * @param size the size to assign
     */
    public void setSize(double size) { this.size = size; }

    /**
     * Returns product details plus shoe-specific information.
     * @return formatted string
     */
    @Override
    public String toString() {
        return super.toString() + "\nSize: " + size;
    }
}

