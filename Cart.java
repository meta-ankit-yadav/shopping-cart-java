import java.util.HashMap;

public class Cart {
    
    private HashMap<Integer, Item> cartMap = new HashMap<>();

    public int size() {
        return cartMap.size();
    }

    public boolean addItem(Item item, int quantity) {

        // Check if Item already exists in cart
        Boolean exists = cartMap.containsKey(item.id());
        if (exists) return false;

        // Add quantity to Item
        Item updatedItem = new Item(item.id(), item.name(), item.description(), item.price(), quantity);

        // Add item to cart
        cartMap.put(item.id(), updatedItem);

        return true;
    }

    public void displayCart() {
        for (Item item : cartMap.values()) {
            System.out.println("    " + item.id() + ". " + item.name() + " - Rs " + item.price() + " - " + item.quantity());
        }
    }

    public void updateQuantity(Integer itemId, Integer updatedQuantity) {

        // Check if any item with provided ID exists
        Boolean exists = cartMap.containsKey(itemId);

        if (exists) {

            // Get the stored item
            Item item = cartMap.get(itemId);

            // Create updated item with new quantity
            Item updatedItem = new Item(item.id(), item.name(), item.description(), item.price(), updatedQuantity);

            // Replace existing item
            cartMap.replace(item.id(), updatedItem);

            System.out.println("Item quantity replaced successfully.");

        } else {
            System.out.println("No item with such ID exists in the cart.");
        }

    }

    public void deleteItem(Integer itemId) {

        // Check if any item with provided ID exists
        Boolean exists = cartMap.containsKey(itemId);

        if (exists) {
            // Delete the item
            cartMap.remove(itemId);
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("No item with such ID exists in the cart.");
        }

    }

    public Double bill() {
        Double totalBill = 0.0;

        // Iterate through each item and add it's value to bill
        for (Item item : cartMap.values()) {
            totalBill += item.quantity() * item.price();
        }

        return totalBill;
    }

}

