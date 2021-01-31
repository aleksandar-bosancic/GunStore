package db.dao.mysql;

import db.dao.ItemHasPurchaseOrderDAO;
import db.dto.ItemHasPurchaseOrder;

import java.util.ArrayList;

public class ItemHasPurchaseOrderDAOMySql implements ItemHasPurchaseOrderDAO {
    @Override
    public ArrayList<ItemHasPurchaseOrder> GetAll() {
        return null;
    }

    @Override
    public boolean createItemHasPurchaseOrder(ItemHasPurchaseOrder ItemHasPurchaseOrder) {
        return false;
    }

    @Override
    public ItemHasPurchaseOrder readItemHasPurchaseOrder(int id) {
        return null;
    }

    @Override
    public boolean updateItemHasPurchaseOrder(ItemHasPurchaseOrder ItemHasPurchaseOrder) {
        return false;
    }

    @Override
    public boolean deleteItemHasPurchaseOrder(int id) {
        return false;
    }
}
