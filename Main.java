public class Main {
    public static void main(String[] args) {

        // Create instance of Cart class (new bill start)
        Cart cart = new Cart();

        // Add item to cart
        CartItem item = new CartItem(null, "Coca Cola", "Small can of coca cola", 40f, 2);
        String addedItemId = cart.addItem(item);

        // Display quantity
        cart.displayQuantity(addedItemId);

        // Update quantity
        cart.updateQuantity(addedItemId, 4);

        // Display quantity again
        cart.displayQuantity(addedItemId);

        // Display bill value
        cart.displayBill();

        // Delete item
        cart.deleteItem(addedItemId);

    }
}