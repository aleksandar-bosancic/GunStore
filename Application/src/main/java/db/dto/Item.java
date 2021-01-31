package db.dto;

public class Item {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private int in_stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(int in_stock) {
        this.in_stock = in_stock;
    }
}
