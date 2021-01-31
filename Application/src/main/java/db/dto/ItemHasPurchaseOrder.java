package db.dto;

public class ItemHasPurchaseOrder {
    private Item item;
    private PurchaseOrder purchaseOrder;
    private int amount;
    private double supplierPrice;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
}
