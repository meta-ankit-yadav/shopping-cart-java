record CartItem(
    String id,
    String name,
    String description,
    Float price,
    Integer quantity
) {
    
    public CartItem(String id, String name, String description, Float price, Integer quantity) { 
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

}
