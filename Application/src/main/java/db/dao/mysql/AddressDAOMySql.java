package db.dao.mysql;

import db.dao.AddressDAO;
import db.dto.Address;

import java.util.ArrayList;

public class AddressDAOMySql implements AddressDAO {
    @Override
    public ArrayList<Address> GetAll() {
        return null;
    }

    @Override
    public boolean createAddress(Address Address) {
        return false;
    }

    @Override
    public Address readAddress(int id) {
        return null;
    }

    @Override
    public boolean updateAddress(Address Address) {
        return false;
    }

    @Override
    public boolean deleteAddress(int id) {
        return false;
    }
}
