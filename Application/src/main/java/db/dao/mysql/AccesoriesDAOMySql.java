package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.AccesoriesDAO;
import db.dao.ItemDAO;
import db.dto.Accesories;
import db.dto.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoriesDAOMySql implements AccesoriesDAO {
    @Override
    public ArrayList<Accesories> GetAll() throws SQLException {
        ArrayList<Accesories> toReturn = new ArrayList<>();
        String query = "select item_id, type, colour, name, manufacturer, model, price, in_stock from Accesories inner join Item ON Accesories.item_id=Item.id";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Accesories accesories = new Accesories();
            accesories.setId(resultSet.getInt("item_id"));
            accesories.setType(resultSet.getString("type"));
            accesories.setColour(resultSet.getString("colour"));
            accesories.setName(resultSet.getString("name"));
            accesories.setManufacturer(resultSet.getString("manufacturer"));
            accesories.setModel(resultSet.getString("model"));
            accesories.setPrice(resultSet.getDouble("price"));
            accesories.setIn_stock(resultSet.getInt("in_stock"));
            toReturn.add(accesories);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createAccesories(Accesories accesories) throws SQLException {
        ItemDAO itemDAO = new ItemDAOMySql();
        itemDAO.createItem((Item)accesories);
        String query = "insert into Accesories(item_id, type, colour, name) values (?, ?, ?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, accesories.getId());
        preparedStatement.setString(2, accesories.getType());
        preparedStatement.setString(3, accesories.getColour());
        preparedStatement.setString(4, accesories.getName());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Accesories readAccesories(int id) throws SQLException {
        ArrayList<Accesories> accesories = this.GetAll();
        for(Accesories accesory : accesories)
        {
            if(accesory.getId() == id){
                return accesory;
            }
        }
        return null;
    }

    @Override
    public boolean updateAccesories(Accesories accesories) throws SQLException {
        String query = "update Accesories set type=?, colour=?, name=? where item_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);;
        preparedStatement.setString(1, accesories.getType());
        preparedStatement.setString(2, accesories.getColour());
        preparedStatement.setString(3, accesories.getName());
        preparedStatement.setInt(4, accesories.getId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteAccesories(int id) throws SQLException {
        String query = "delete from Accesories where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
