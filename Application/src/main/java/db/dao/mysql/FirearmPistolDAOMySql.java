package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.FirearmPistolDAO;
import db.dao.ItemDAO;
import db.dto.FirearmPistol;
import db.dto.Item;
import db.dto.Pistol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FirearmPistolDAOMySql implements FirearmPistolDAO {
    @Override
    public ArrayList<FirearmPistol> GetAll() throws SQLException {
        ArrayList<FirearmPistol> toReturn = new ArrayList<>();
        String query = "select firearm_pistol.item_id, caliber, magazine_capacity, manufacturer, model, price, in_stock " +
                        "from firearm_pistol " +
                        "inner join pistol on firearm_pistol.item_id = pistol.item_id " +
                        "inner join item on firearm_pistol.item_id=item.id";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            FirearmPistol pistol = new FirearmPistol();
            pistol.setId(resultSet.getInt("item_id"));
            pistol.setCaliber(resultSet.getString("caliber"));
            pistol.setMagazineCapacity(resultSet.getInt("magazine_capacity"));
            pistol.setManufacturer(resultSet.getString("manufacturer"));
            pistol.setModel(resultSet.getString("model"));
            pistol.setPrice(resultSet.getDouble("price"));
            pistol.setIn_stock(resultSet.getInt("in_stock"));
            toReturn.add(pistol);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createFirearmPistol(FirearmPistol firearmPistol) throws SQLException {
        ItemDAO itemDAO = new ItemDAOMySql();
        itemDAO.createItem((Item)firearmPistol);
        String query = "insert into firearm_pistol(item_id) values (?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, firearmPistol.getId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public FirearmPistol readFirearmPistol(int id) throws SQLException {
        ArrayList<FirearmPistol> pistols = this.GetAll();
        for(FirearmPistol pistol : pistols){
            if(pistol.getId() == id){
                return pistol;
            }
        }
        return null;
    }

    @Override
    public boolean updateFirearmPistol(FirearmPistol FirearmPistol) {
        return false;
    } //Nothing to update

    @Override
    public boolean deleteFirearmPistol(int id) throws SQLException {
        String query = "delete from firearm_pistol where item_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
