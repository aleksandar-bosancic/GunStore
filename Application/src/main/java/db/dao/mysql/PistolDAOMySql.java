package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.ItemDAO;
import db.dao.PistolDAO;
import db.dto.Item;
import db.dto.Pistol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PistolDAOMySql implements PistolDAO {
    @Override
    public ArrayList<Pistol> GetAll() throws SQLException {
        ArrayList<Pistol> toReturn = new ArrayList<>();
        String query = "select item_id, caliber, magazine_capacity, manufacturer, model, price, in_stock from Pistol inner join Item ON Pistol.item_id=Item.id";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Pistol pistol = new Pistol();
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
    public boolean createPistol(Pistol pistol) throws SQLException {
        ItemDAO itemDAO = new ItemDAOMySql();
        itemDAO.createItem((Item)pistol);
        String query = "insert into Pistol(item_id, caliber, magazine_capacity) values (?, ?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, pistol.getId());
        preparedStatement.setString(2, pistol.getCaliber());
        preparedStatement.setInt(3, pistol.getMagazineCapacity());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Pistol readPistol(int id) throws SQLException {
        ArrayList<Pistol> pistols = this.GetAll();
        for(Pistol pistol : pistols){
            if(pistol.getId() == id){
                return pistol;
            }
        }
        return null;
    }

    @Override
    public boolean updatePistol(Pistol pistol) throws SQLException {
        String query = "update Pistol set caliber=?, magazine_capacity=? where item_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, pistol.getCaliber());
        preparedStatement.setInt(2, pistol.getMagazineCapacity());
        preparedStatement.setInt(3, pistol.getId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deletePistol(int id) throws SQLException {
        String query = "delete from Pistol where item_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
