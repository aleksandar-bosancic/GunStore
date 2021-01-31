package db.dao;

import db.dto.Address;

import java.util.ArrayList;

public interface AddressDAO {
    public ArrayList<Address> GetAll();
    public boolean createAddress(Address Address);
    public Address readAddress(int id);
    public boolean updateAddress(Address Address);
    public boolean deleteAddress(int id);
}
