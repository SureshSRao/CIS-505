/**
 * The Fan class models a simple fan with speed, on/off state, radius, and color.
 * It provides constructors, accessors, mutators, and a string description.
 * 
 * Assignment 1.3
 * 
 * Features:
 *  - Constants for STOPPED, SLOW, MEDIUM, and FAST speeds.
 *  - Encapsulated fields for fan attributes.
 *  - No-argument and argument constructors.
 *  - Overridden toString() method for output formatting.
 * 
 * @author Sripathi Rao Suresh
 * @version 1.0
 */
public class Fan {

    /** Constant for stopped fan speed */
    public static final int STOPPED = 0;
    /** Constant for slow fan speed */
    public static final int SLOW = 1;
    /** Constant for medium fan speed */
    public static final int MEDIUM = 2;
    /** Constant for fast fan speed */
    public static final int FAST = 3;

    /** The speed of the fan */
    private int speed;
    /** The on/off state of the fan */
    private boolean on;
    /** The radius of the fan */
    private double radius;
    /** The color of the fan */
    private String color;

    /**
     * Default constructor.
     * Initializes the fan with default values:
     * speed = STOPPED, on = false, radius = 6.0, color = "white".
     */
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6.0;
        this.color = "white";
    }

    /**
     * Argument constructor.
     * Initializes the fan with specified values.
     *
     * @param speed  the speed of the fan
     * @param on     the on/off state of the fan
     * @param radius the radius of the fan
     * @param color  the color of the fan
     */
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Gets the current fan speed.
     *
     * @return speed of the fan
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the fan.
     *
     * @param speed speed of the fan (STOPPED, SLOW, MEDIUM, FAST)
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Checks if the fan is on.
     *
     * @return true if fan is on, false otherwise
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Sets the on/off state of the fan.
     *
     * @param on true if fan should be on, false otherwise
     */
    public void setOn(boolean on) {
        this.on = on;
    }

    /**
     * Gets the radius of the fan.
     *
     * @return radius of the fan
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the fan.
     *
     * @param radius radius of the fan
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Gets the color of the fan.
     *
     * @return color of the fan
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the fan.
     *
     * @param color color of the fan
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns a string description of the fan.
     * If the fan is on, includes speed, color, and radius.
     * If the fan is off, includes color, radius, and an "off" message.
     *
     * @return string representation of the fan
     */
    @Override
    public String toString() {
        if (on) {
            return "The fan speed is set to " + speed +
                   " with a color of " + color +
                   " and a radius of " + radius;
        } else {
            return "The fan is " + color +
                   " with a radius of " + radius +
                   " and the fan is off";
        }
    }
}
