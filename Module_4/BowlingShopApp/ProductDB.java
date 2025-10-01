package Module_4.BowlingShopApp;

/**
 * ProductDB simulates a database for bowling shop products.
 * It creates and returns product queues based on input codes.
 * Assignment 4.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class ProductDB {

    public static final java.util.List<String> ballDescription = 
    java.util.Collections.unmodifiableList(
        java.util.Arrays.asList("Phaze III", "Force Unleashed", "Proton Physix","Axion Pearl","Black Widow 2.0")
    );

    public static final java.util.List<String> shoeDescription = 
    java.util.Collections.unmodifiableList(
        java.util.Arrays.asList("Youth Skull Green/Black", "Men's Tribal White", "Women's Path Lite Seamless Mesh","Women's Rise Black/Hot Pink","Men's Ram Black")
    );

    public static final java.util.List<String> bagDescription = 
    java.util.Collections.unmodifiableList(
        java.util.Arrays.asList("Silver/Royal Blue", "Prime Roller Black/Royal Blue", "Path Pro Deluxe")
    );

    /**
     * Returns a queue of products based on code entered.
     * b = Balls, s = Shoes, a = Bags
     *
     * @param code product category code
     * @return GenericQueue of products
     */
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<>();

        if (code.equalsIgnoreCase("b")) {
            for (int i = 1,j=4; i <= 5; i++,j--) {
                Ball ball = new Ball();
                ball.setCode("B" + i*100);
                ball.setDescription(ballDescription.get(j));
                ball.setPrice(59.95 + i * 10);
                ball.setColor(i % 2 == 0 ? "Red and White" : "Pink and Purple");
                products.enqueue(ball);
            }
        } else if (code.equalsIgnoreCase("s")) {
            for (int i = 1,j=4; i <= 5; i++,j--) {
                Shoe shoe = new Shoe();
                shoe.setCode("S" + i*100);
                shoe.setDescription(shoeDescription.get(j));
                shoe.setPrice(39.95 + i * 5);
                shoe.setSize(7 + i);
                products.enqueue(shoe);
            }
        } else if (code.equalsIgnoreCase("a")) {
            for (int i = 1,j=2; i <= 3; i++,j--) {
                Bag bag = new Bag();
                bag.setCode("A" + i*100);
                bag.setDescription(bagDescription.get(j));
                bag.setPrice(29.95 + i * 7);
                bag.setType(i == 1 ? "Single" : i == 2 ? "Double" : "Triple");
                products.enqueue(bag);
            }
        }

        return products;
    }
}

