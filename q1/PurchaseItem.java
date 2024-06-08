/*
  A class which represents an item that has been purchased by an item's object, a quantity of this item
 and a total sum of this item.
 */
package q1;

public class PurchaseItem {
    //Instance variables.
    private Item item;
    private int quantity;
    private double itemTotal;

    /**
     * A constructor to purchased item which initializes item, quantity and item's total.
     * @param item
     * @param quantity
     */
    public PurchaseItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.itemTotal = item.getPrice() * quantity;
    }


    /**
     * A method which returns an item's object.
     * @return Item's object.
     */
    public Item getItem() {
        return item;
    }

    /**
     *  A method which returns an item's quantity.
     * @return Item's quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * A method which returns a total sum of this item.
     * @return Item's total.
     */
    public double getItemTotal() {
        return itemTotal;
    }
}