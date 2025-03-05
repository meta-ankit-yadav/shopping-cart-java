// Alternative of records

public class Item {
    private String id;
    private String name;
    private String description;
    private Float price;
    private Integer quantity;

    public Item(String id, String name, String description, Float price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Float price() {
        return price;
    }

    public Integer quantity() {
        return quantity;
    }
}
