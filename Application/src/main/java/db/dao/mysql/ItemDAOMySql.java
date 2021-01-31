package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.ItemDAO;
import db.dto.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOMySql implements ItemDAO {
    @Override
    public ArrayList<Item> GetAll() throws SQLException {
        ArrayList<Item> toReturn = new ArrayList<>();
        String query = "select id, manufacturer, model, price, in_stock from Item";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Item item = new Item();
            item.setId(resultSet.getInt("id"));
            item.setManufacturer(resultSet.getString("manufacturer"));
            item.setModel(resultSet.getString("model"));
            item.setPrice(resultSet.getDouble("price"));
            item.setIn_stock(resultSet.getInt("in_stock"));
            toReturn.add(item);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createItem(Item item) throws SQLException {
        String query = "insert into Item(manufacturer, model, price, in_stock)"
                + "values(?, ?, ?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, item.getManufacturer());
        preparedStatement.setString(2, item.getModel());
        preparedStatement.setDouble(3, item.getPrice());
        preparedStatement.setInt(4, item.getIn_stock());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Item readItem(int id) throws SQLException {
        String query = "select manufacturer, model, price, in_stock from Item where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Item toReturn = new Item();
        resultSet.next();
        toReturn.setId(id);
        toReturn.setManufacturer(resultSet.getString("manufacturer"));
        toReturn.setModel(resultSet.getString("model"));
        toReturn.setPrice(resultSet.getDouble("price"));
        toReturn.setIn_stock(resultSet.getInt("in_stock"));
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean updateItem(Item item) throws SQLException {
        String query = "update Item set manufacturer=?, model=?, price=?, in_stock=? where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);;
        preparedStatement.setString(1, item.getManufacturer());
        preparedStatement.setString(2, item.getModel());
        preparedStatement.setDouble(3, item.getPrice());
        preparedStatement.setInt(4, item.getIn_stock());
        preparedStatement.setInt(5, item.getId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteItem(int id) throws SQLException {
        String query = "delete from Item where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
