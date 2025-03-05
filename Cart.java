import java.util.HashMap;
import java.util.UUID;

public class Cart {
    
    private HashMap<String, CartItem> cartMap = new HashMap<>();

    public String addItem(CartItem item) {
        String key = UUID.randomUUID().toString();

        // Add the generated key to item
        CartItem updatedItem = new CartItem(key, item.name(), item.description(), item.price(), item.quantity());

        cartMap.put(key, updatedItem); 

        return key;
    }

    public void displayQuantity(String itemId) {

        // Check if any item with provided ID exists
        Boolean exists = cartMap.containsKey(itemId);

        if (exists) {
            
            // Get the stored item
            CartItem item = cartMap.get(itemId);

            // Get the name and quantity of item
            String name = item.name();
            Integer quantity = item.quantity();

            // Print a message indicating quantity of item
            System.out.println("The quantity for product named " + name + " is " + quantity);
        } else {
            System.out.println("No item with such ID exists in the cart.");
        }
    
    }

    public void updateQuantity(String itemId, Integer updatedQuantity) {

        // Check if any item with provided ID exists
        Boolean exists = cartMap.containsKey(itemId);

        if (exists) {

            // Get the stored item
            CartItem item = cartMap.get(itemId);

            // Create updated item with new quantity
            CartItem updatedItem = new CartItem(item.id(), item.name(), item.description(), item.price(), updatedQuantity);

            // Replace existing item
            cartMap.replace(item.id(), updatedItem);

        } else {
            System.out.println("No item with such ID exists in the cart.");
        }

    }

    public void deleteItem(String itemId) {

        // Check if any item with provided ID exists
        Boolean exists = cartMap.containsKey(itemId);

        if (exists) {
            // Delete the item
            cartMap.remove(itemId);
        } else {
            System.out.println("No item with such ID exists in the cart.");
        }

    }

    public void displayBill() {

        // Start with total bill as 0
        Double totalBill = 0.0;

        // Iterate through each item and add it's value to bill
        for (CartItem item : cartMap.values()) {
            totalBill += item.quantity() * item.price();
        }

        // Print the total bill value
        System.out.println("Total bill value: " + totalBill);

    }

}

