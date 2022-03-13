package products;

public class Products {
    private String name;
    private int price;

    public Products(String name, int price) {
        this.name = name;
        this.price = price;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setAge(int price) {
        this.price = price;
    }
}
