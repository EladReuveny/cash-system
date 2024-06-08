/*
 * Q1
 * This class represents a cash that collects the customer's account information who makes a purchase,
 calculates an aggregate of a purchase, receives money from the customer and calculates an excess for him,
 and calculates the grocery of all the purchases of all the buyers.
 */
package q1;

import java.util.ArrayList;

public class Cash {
   /**
    * Instance variables.
    */
    private ArrayList<PurchaseItem> currentCustomer;
    private double checkoutBalance;

    /**
     * An empty constructor which produces an empty cash.
     */
    public Cash() {
        this.currentCustomer = new ArrayList<PurchaseItem>();
        this.checkoutBalance = 0.0;
    }

    /**
     * A constructor which initializes the checkout balance to a particular parameter.
     * @param initialBalance
     */
    public Cash(double initialBalance) {
        this.currentCustomer = new ArrayList<PurchaseItem>();
        this.checkoutBalance = initialBalance;
    }

    /**
     * A method which adding an item to current customer's account.
     * @param item
     * @param quantity
     */
    public void addItem(Item item, int quantity) {
        currentCustomer.add(new PurchaseItem(item, quantity));
    }

    /**
     * A method which returns a string representing the current customer's account.
     * @return A string which represent the current customer's account.
     */
    public String getCustomerAccount() {
        StringBuilder account = new StringBuilder();
        for (int i = 0; i < currentCustomer.size(); i++) {
            PurchaseItem purchaseItem = currentCustomer.get(i);
            account.append( "(" + (i + 1) + ")" +" Item name: " + purchaseItem.getItem().getName() + " \t " )
                    .append("Amount:  " + purchaseItem.getQuantity() + " \t ")
                    .append("Payment for item: " + purchaseItem.getItemTotal() + " $")
                    .append("\n");
        }
        return account.toString();
    }

    /**
     * A method which returns the total amount of the current customer's purchase.
     * @return The total amount of the current customer's purchase.
     */
    public double getCustomerPurchaseTotal() {
        double purchaseTotal = 0.0;
        for (int i = 0; i < currentCustomer.size(); i++) {
            PurchaseItem purchaseItem = currentCustomer.get(i);
            purchaseTotal += purchaseItem.getItemTotal();
        }
        return purchaseTotal;
    }

    /**
     * A method that receives payment from the buyer, and returns the excess. This method resets the current purchase details and updates the amount
     which is included in the checkout.
     * @param amountPaid The amount which has been paid by the customer.
     * @return The excess to refund to the customer.
     */
    public double getExcess(double amountPaid) {
        double purchaseTotal = getCustomerPurchaseTotal();
        if (amountPaid < purchaseTotal) {
            System.out.println("Insufficient amount received.");
            return 0.0; // Return 0 as the excess since the amount paid is insufficient.
        }

        // The amount paid is sufficient.
        checkoutBalance += purchaseTotal;
        return amountPaid - purchaseTotal;
    }


    /**
     * A method that returns the total amount in the cash .
     * @return The checkout balance in the cash.
     */
    public double getCheckoutBalance() {
        return checkoutBalance;
    }

    /**
     * A method which deletes the whole data of the current customer.
     */
    public void clearCurrentCustomer() {
        currentCustomer.clear();
        checkoutBalance = 0.0;
    }
}