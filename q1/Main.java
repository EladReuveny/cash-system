package q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cash cash = new Cash();

        boolean shopping = true;

        System.out.println("=== Welcome to the Cash System ===");

        String[] products = {"Product A", "Product B", "Product C", "Product D", "Product E",
                "Product F", "Product G", "Product H", "Product I", "Product J"};

        double[] prices = {10.0, 15.0, 20.0, 12.5, 18.5, 9.99, 25.0, 16.0, 22.75, 11.5};

        while (shopping) {
            System.out.println("\n-- Add Item --");
            System.out.println("Available products:");
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " $");
            }

            System.out.println("\nEnter the product number:");
            int productNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            if (productNumber < 1 || productNumber > products.length) {
                System.out.println("Invalid product number. Please try again.");
                continue;
            }

            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            String productName = products[productNumber - 1];
            double price = prices[productNumber - 1];

            Item item = new Item(productName, price);
            cash.addItem(item, quantity);

            System.out.println("\nDo you want to add another item? (y/n)");
            String choice = scanner.nextLine().toLowerCase();

            while (!choice.equals("y") && !choice.equals("n")) {
                System.out.println("Invalid choice. Please enter 'y' or 'n':");
                choice = scanner.nextLine().toLowerCase();
            }

            shopping = choice.equals("y");
        }

        System.out.println("\n-- Payment --");
        System.out.println("Enter the amount paid:");
        double amountPaid = scanner.nextDouble();

        double excess = cash.getExcess(amountPaid);
        if (excess == 0.0)
            System.out.println("\nSufficient amount received. No change will be given.");
        else
            System.out.println("\nExcess: " + excess + " $");

        System.out.println("\n-- Customer Account --");
        System.out.println(cash.getCustomerAccount());

        System.out.println("\nCheckout balance: " + cash.getCheckoutBalance() + " $");

        // Finishing the process with the current customer and moving on to the next customer.
        cash.clearCurrentCustomer();
    }
}
