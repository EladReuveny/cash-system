/*
 * This class represents an item which has a name and a price as his attributes.
 */
package q1;

public class Item {
    //Instance variables.
    private String name;
    private double price;


    /**
     * A constructor which initializes name and price to particular parameters.
     * @param name
     * @param price
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * A method which returns the item's name.
     * @return Item's name.
     */
    public String getName() {
        return name;
    }

    /**
     * A method which returns the item's price.
     * @return Item's price.
     */
    public double getPrice() {
        return price;
    }
}