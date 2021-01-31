package db.dao;

import db.dto.Supplier;

import java.util.ArrayList;

public interface SupplierDAO {
    public ArrayList<Supplier> GetAll();
    public boolean createSupplier(Supplier Supplier);
    public Supplier readSupplier(int id);
    public boolean updateSupplier(Supplier Supplier);
    public boolean deleteSupplier(int id);
}
