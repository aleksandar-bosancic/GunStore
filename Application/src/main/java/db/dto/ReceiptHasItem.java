package db.dto;

public class ReceiptHasItem {
    private Receipt receipt;
    private Item item;
    private int amount;
    private double itemPrice;



    public String getManufacturer() {
        return item.getManufacturer();
    }

    public String getModel() {
        return item.getModel();
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
