public class Item {
    private Integer id;
    private String name;
    private String description;
    private Float price;
    private Integer quantity;

    public Item(int id, String name, String description, Float price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public float price() {
        return price;
    }

    public int quantity() {
        return quantity;
    }
}
