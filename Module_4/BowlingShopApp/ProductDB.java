/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class ProductDB {
    
    /**
     * Public static method with one argument, which is used to create a set of products based on a provided String value.
     * @param code String 
     * @return a GenericQueue<Product> object based on code provided.
     */
    public static GenericQueue<Product> getProducts(String code) {
        /** if statement to control which products are instantiated. */
        if (code.equalsIgnoreCase("b")) {
            /** Instantiate ball1 */
            Ball ball1 = new Ball();
            ball1.setCode("B100");
            ball1.setDescription("Black Widow 2.0");
            ball1.setPrice(144.95);
            ball1.setColor("Black and Red");

            /** Instantiate ball2 */
            Ball ball2 = new Ball();
            ball2.setCode("B200");
            ball2.setDescription("Axiom Pearl");
            ball2.setPrice(154.95);
            ball2.setColor("Blue and Red");

            /** Instantiate ball3 */
            Ball ball3 = new Ball();
            ball3.setCode("B300");
            ball3.setDescription("Proton Physix");
            ball3.setPrice(174.95);
            ball3.setColor("Pink and Purple");

            /** Instantiate ball4 */
            Ball ball4 = new Ball();
            ball4.setCode("B400");
            ball4.setDescription("Force Unleashed");
            ball4.setPrice(139.99);
            ball4.setColor("Red and White");

            /** Instantiate ball5 */
            Ball ball5 = new Ball();
            ball5.setCode("B500");
            ball5.setDescription("Phaze III");
            ball5.setPrice(154.99);
            ball5.setColor("Purple and Green");

            /** Populate generic queue with instantiated balls. */
            GenericQueue<Product> balls = new GenericQueue<>();
            balls.enqueue(ball1);
            balls.enqueue(ball2);
            balls.enqueue(ball3);
            balls.enqueue(ball4);
            balls.enqueue(ball5);

            return balls; // return generic queue balls.
        } else if (code.equalsIgnoreCase("s")) {
            /** Instantiate shoe1 */
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S100");
            shoe1.setDescription("Men's Ram Black");
            shoe1.setPrice(39.99);
            shoe1.setSize(10.5);

            /** Instantiate shoe2 */
            Shoe shoe2 = new Shoe();
            shoe2.setCode("S200");
            shoe2.setDescription("Women's Rise Black/Hot Pink");
            shoe2.setPrice(39.99);
            shoe2.setSize(7.0);

            /** Instantiate shoe3 */
            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Women's Path Lite Seamless Mesh");
            shoe3.setPrice(54.99);
            shoe3.setSize(6.0);

            /** Instantiate shoe4 */
            Shoe shoe4 = new Shoe();
            shoe4.setCode("S400");
            shoe4.setDescription("Men's Tribal White");
            shoe4.setPrice(26.99);
            shoe4.setSize(8.5);

            /** Instantiate shoe5 */
            Shoe shoe5 = new Shoe();
            shoe5.setCode("S500");
            shoe5.setDescription("Youth Skull Green/Black");
            shoe5.setPrice(39.99);
            shoe5.setSize(3.0);

            /** Populate generic queue with instantiated shoes. */
            GenericQueue<Product> shoes = new GenericQueue<>();
            shoes.enqueue(shoe1);
            shoes.enqueue(shoe2);
            shoes.enqueue(shoe3);
            shoes.enqueue(shoe4);
            shoes.enqueue(shoe5);

            return shoes; // return generic queue shoes.
        } else if (code.equalsIgnoreCase("a")) {
            /** Instantiate bag1 */
            Bag bag1 = new Bag();
            bag1.setCode("A100");
            bag1.setDescription("Path Pro Deluxe");
            bag1.setPrice(34.99);
            bag1.setType("Single");

            /** Instantiate bag2 */
            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Prime Roller Black/Royal Blue");
            bag2.setPrice(54.99);
            bag2.setType("Double");

            /** Instantiate bag3 */
            Bag bag3 = new Bag();
            bag3.setCode("A300");
            bag3.setDescription("Silver/Royal Blue");
            bag3.setPrice(74.99);
            bag3.setType("Triple");

            /** Populate generic queue with instantiated bags. */
            GenericQueue<Product> bags = new GenericQueue<>();
            bags.enqueue(bag1);
            bags.enqueue(bag2);
            bags.enqueue(bag3);

            return bags; // return generic queue bags.
        } else {
            return new GenericQueue<Product>(); // return empty Product generic queue.
        } // end if
    } // end getProducts

} // end ProductDB
