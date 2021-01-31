package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.ReceiptHasItemDAO;
import db.dto.Address;
import db.dto.ReceiptHasItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReceiptHasItemDAOMySql implements ReceiptHasItemDAO {
    @Override
    public ArrayList<ReceiptHasItem> GetAll() throws SQLException {
        ArrayList<ReceiptHasItem> toReturn = new ArrayList<>();
        String query = "select receipt_id, item_id, ammount, item_price from Receipt_has_Item";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            ReceiptHasItem receiptHasItem = new ReceiptHasItem();
            receiptHasItem.setReceipt(new ReceiptDAOMySql().readReceipt(resultSet.getInt("receipt_id")));
            receiptHasItem.setItem(new ItemDAOMySql().readItem(resultSet.getInt("item_id")));
            receiptHasItem.setAmount(resultSet.getInt("ammount"));
            receiptHasItem.setItemPrice(resultSet.getDouble("item_price"));
            toReturn.add(receiptHasItem);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createReceiptHasItem(ReceiptHasItem receiptHasItem) throws SQLException {
        String query = "insert into Receipt_has_Item(receipt_id, item_id, ammount, item_price)"
                + "values(?, ?, ?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, receiptHasItem.getReceipt().getId());
        preparedStatement.setInt(2, receiptHasItem.getItem().getId());
        preparedStatement.setInt(3, receiptHasItem.getAmount());
        preparedStatement.setDouble(4, receiptHasItem.getItemPrice());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public ReceiptHasItem readReceiptHasItem(int receipt_id, int item_id) throws SQLException {
        ArrayList<ReceiptHasItem> receiptHasItems = this.GetAll();
        for(ReceiptHasItem receiptHasItem : receiptHasItems){
            if(receiptHasItem.getReceipt().getId() == receipt_id && receiptHasItem.getItem().getId() == item_id){
                return receiptHasItem;
            }
        }
        return null;
    }

    @Override
    public boolean updateReceiptHasItem(ReceiptHasItem receiptHasItem) throws SQLException {
        String query = "update Receipt_has_Item set ammount=?, item_price=? where receipt_id=? and item_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, receiptHasItem.getAmount());
        preparedStatement.setDouble(2, receiptHasItem.getItemPrice());
        preparedStatement.setInt(3, receiptHasItem.getReceipt().getId());
        preparedStatement.setInt(4, receiptHasItem.getItem().getId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteReceiptHasItem(int receipt_id, int item_id) throws SQLException {
        String query = "delete from Receipt_has_Item where receipt_id=? and item_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, receipt_id);
        preparedStatement.setInt(2, item_id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
