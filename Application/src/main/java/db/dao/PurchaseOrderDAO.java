package db.dao;

import db.dto.PurchaseOrder;

import java.util.ArrayList;

public interface PurchaseOrderDAO {
    public ArrayList<PurchaseOrder> GetAll();
    public boolean createPurchaseOrder(PurchaseOrder PurchaseOrder);
    public PurchaseOrder readPurchaseOrder(int id);
    public boolean updatePurchaseOrder(PurchaseOrder PurchaseOrder);
    public boolean deletePurchaseOrder(int id);
}
