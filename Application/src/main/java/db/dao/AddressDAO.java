package db.dao;

import db.dto.Address;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddressDAO {
    public ArrayList<Address> GetAll() throws SQLException;
    public boolean createAddress(Address address) throws SQLException;
    public Address readAddress(int id) throws SQLException;
    public boolean updateAddress(Address address) throws SQLException;
    public boolean deleteAddress(int id) throws SQLException;
}
