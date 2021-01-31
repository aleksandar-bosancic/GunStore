package db.dao.mysql;

import db.dao.SupplierDAO;
import db.dto.Supplier;

import java.util.ArrayList;

public class SupplierDAOMySql implements SupplierDAO {
    @Override
    public ArrayList<Supplier> GetAll() {
        return null;
    }

    @Override
    public boolean createSupplier(Supplier Supplier) {
        return false;
    }

    @Override
    public Supplier readSupplier(int id) {
        return null;
    }

    @Override
    public boolean updateSupplier(Supplier Supplier) {
        return false;
    }

    @Override
    public boolean deleteSupplier(int id) {
        return false;
    }
}
