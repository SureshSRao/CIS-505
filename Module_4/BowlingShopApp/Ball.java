package Module_4.BowlingShopApp;

/**
 * Ball represents a bowling ball product.
 * Extends Product and adds the color property.
 * Assignment 4.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class Ball extends Product {
    /** Color of the bowling ball */
    private String color = "";

    /** Default constructor */
    public Ball() {}

    /**
     * Returns the ball color.
     * @return color of the ball
     */
    public String getColor() { return color; }

    /**
     * Sets the ball color.
     * @param color the color to assign
     */
    public void setColor(String color) { this.color = color; }

    /**
     * Returns product details plus ball-specific information.
     * @return formatted string
     */
    @Override
    public String toString() {
        return super.toString() + "\n  Color: " + color;
    }
}

