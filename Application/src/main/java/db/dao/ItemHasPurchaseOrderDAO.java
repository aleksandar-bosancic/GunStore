package db.dao;

import db.dto.ItemHasPurchaseOrder;

import java.util.ArrayList;

public interface ItemHasPurchaseOrderDAO {
    public ArrayList<ItemHasPurchaseOrder> GetAll();
    public boolean createItemHasPurchaseOrder(ItemHasPurchaseOrder ItemHasPurchaseOrder);
    public ItemHasPurchaseOrder readItemHasPurchaseOrder(int id);
    public boolean updateItemHasPurchaseOrder(ItemHasPurchaseOrder ItemHasPurchaseOrder);
    public boolean deleteItemHasPurchaseOrder(int id);
}
