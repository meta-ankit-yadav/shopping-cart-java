import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner to take user input
        Scanner sc = new Scanner(System.in);

        // Create instance of cart (new bill start)
        Cart cart = new Cart();

        while (true) {

            int userInput = -1;

            System.out.println("---------------------------------------------------");
            System.out.println("Choose an action:");
            System.out.println("    1. Add Item");
            System.out.println("    2. Update Quantity");
            System.out.println("    3. Display Cart");
            System.out.println("    4. Display Bill");
            System.out.println("    9. Delete Item");
            System.out.println("    0. Exit");
            System.out.print("Enter your choice: ");

            // Take input from user
            try {
                userInput = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Invalid input" + e.getMessage());
            }

            switch (userInput) {
                case 1: // Add
                    handleAddItem(cart, sc);
                    break;
                case 2: // Update quantity
                    handleUpdateQuantity(cart, sc);
                    break;
                case 3: // Display 
                    cart.displayCart();
                    break;
                case 4: // Display bill
                    System.out.println("Total bill value: " + cart.bill());
                    break;
                case 9: // Delete item
                    handleDeleteItem(cart, sc);
                    break;
                case 0:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    sc.close();
                    System.exit(1);
            }
        }

    }

    public static void handleDeleteItem(Cart cart, Scanner sc) {

        System.out.println("Which item do you want to delete");
        cart.displayCart();

        int chosenItem = 0;

        try {
            System.out.print("Select a product to delete from above: ");
            chosenItem = sc.nextInt();
        } catch (Exception e) {
            System.err.println("Invalid Input");
            return;
        }

        cart.deleteItem(chosenItem);

    }

    public static void handleUpdateQuantity(Cart cart, Scanner sc) {

        System.out.println("Which item do you want to update");
        cart.displayCart();

        int chosenItem = 0;
        int quantity = 0;

        try {
            System.out.print("Select a product from above: ");
            chosenItem = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
            return;
        }

        try {
            System.out.print("Updated Quantity: ");
            quantity = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Using default 1 for quantity");
        } finally {
            if (quantity < 1) {
                System.out.println("Quantity is not valid");
                return;
            }
        }

        cart.updateQuantity(chosenItem, quantity);
    }

    public static void handleAddItem(Cart cart, Scanner sc) {

        System.out.println("\nSelect a product from below to add to cart: ");
        for (Item item : availableItems) {
            System.out.println("    " + item.id() + ". " + item.name() + " - Rs " + item.price());
        };
    
        int chosenItem = 0;
        int quantity = 1;
        try {
            System.out.print("Enter your choice: ");
            chosenItem = sc.nextInt();
        } catch (Exception e) { 
            // Do nothing for exception here, it is handled in finally
        } finally {
            if (chosenItem < 1 || chosenItem > availableItems.size()) {
                System.err.println("Invalid Input");
                return;
            }
        }


        try {
            System.out.print("Quantity of product to add: ");
            quantity = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Using default 1 for quantity");
        } finally {
            if (quantity < 1) {
                System.out.println("Quantity is not valid");
                return;
            }
        }

        Boolean successful = cart.addItem(availableItems.get(chosenItem - 1), quantity);

        if (successful) {
            System.out.println("Product added successfully. Bill value: " + cart.bill());
        } else {
            System.out.println("Selected product already exists in cart. Try updating the quantity");
        }

    }

    // Pre define available items
    public static ArrayList<Item> availableItems = new ArrayList<>() {
        {
            add(new Item(1, "Coca Cola", "Small coca cola can", 40f, 0));
            add(new Item(2, "Coffee", "Roasted coffee beans for tasteful coffee", 15f, 0));
            add(new Item(3, "Mountain Dew", "Darr ke aage jeet hai", 20f, 0));
            add(new Item(4, "Real fruit juice", "A mouth watering delight of fresh juices", 30f, 0));
            add(new Item(5, "Sweet Lassi", "A sugar free sweet :)", 35f, 0));
        }
    };
}