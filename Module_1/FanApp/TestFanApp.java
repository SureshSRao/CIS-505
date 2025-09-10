/**
 * TestFanApp is the driver class that tests the Fan class.
 * It creates two Fan objects: one with default constructor
 * and one with argument constructor. It displays their details
 * using the overridden toString() method.
 * 
 * Assignment 1.3
 * 
 * Expected Output:
 *  The fan is white with a radius of 6.0 and the fan is off
 *  The fan speed is set to 2 with a color of Blue and a radius of 8.0
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class TestFanApp {
    /**
     * Main method that creates and tests Fan objects.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a fan with default constructor
        Fan fan1 = new Fan();

        // Create a fan with argument constructor
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        // Display the fans using toString()
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
