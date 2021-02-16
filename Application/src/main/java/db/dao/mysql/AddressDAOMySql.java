package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.AddressDAO;
import db.dto.Address;
import db.dto.Person;

import java.sql.*;
import java.util.ArrayList;

public class AddressDAOMySql implements AddressDAO {
    @Override
    public ArrayList<Address> GetAll() throws SQLException {
        ArrayList<Address> toReturn = new ArrayList<>();
        String query = "select id, city, street, number from Address";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Address address = new Address();
            address.setId(resultSet.getInt("id"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setNumber(resultSet.getInt("number"));
            toReturn.add(address);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createAddress(Address address) throws SQLException {
        String query = "insert into Address(city, street, number)"
                + "values(?, ?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, address.getCity());
        preparedStatement.setString(2, address.getStreet());
        preparedStatement.setInt(3, address.getNumber());
        boolean status = preparedStatement.executeUpdate() == 1;
        var rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int autoIncKeyFromApi = rs.getInt(1);
            address.setId(autoIncKeyFromApi);
            rs.close();
        } else {

        }
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Address readAddress(int id) throws SQLException {
        ArrayList<Address> addresses = this.GetAll();
        for(Address address : addresses){
            if(address.getId() == id){
                return address;
            }
        }
        return null;
    }

    @Override
    public boolean updateAddress(Address address) throws SQLException {
        String query = "update Address set city=?, street=?, number=? where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, address.getCity());
        preparedStatement.setString(2, address.getStreet());
        preparedStatement.setInt(3, address.getNumber());
        preparedStatement.setInt(4, address.getId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteAddress(int id) throws SQLException {
        String query = "delete from Address where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
