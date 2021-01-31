package db.dao.mysql;

import db.dao.PurchaseOrderDAO;
import db.dto.PurchaseOrder;

import java.util.ArrayList;

public class PurchaseOrderDAOMySql implements PurchaseOrderDAO {
    @Override
    public ArrayList<PurchaseOrder> GetAll() {
        return null;
    }

    @Override
    public boolean createPurchaseOrder(PurchaseOrder PurchaseOrder) {
        return false;
    }

    @Override
    public PurchaseOrder readPurchaseOrder(int id) {
        return null;
    }

    @Override
    public boolean updatePurchaseOrder(PurchaseOrder PurchaseOrder) {
        return false;
    }

    @Override
    public boolean deletePurchaseOrder(int id) {
        return false;
    }
}
