package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.ReceiptDAO;
import db.dto.Address;
import db.dto.Receipt;

import java.sql.*;
import java.util.ArrayList;

public class ReceiptDAOMySql implements ReceiptDAO {
    @Override
    public ArrayList<Receipt> GetAll() throws SQLException {
        ArrayList<Receipt> toReturn = new ArrayList<>();
        String query = "select id, employee_id, buyer_id, date_time, total_price from Receipt";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Receipt receipt = new Receipt();
            receipt.setId(resultSet.getInt("id"));
            receipt.setEmployee(new EmployeeDAOMySql().readEmployee(resultSet.getInt("employee_id")));
            receipt.setBuyer(new BuyerDAOMySql().readBuyer(resultSet.getInt("buyer_id")));
            receipt.setDateTime(resultSet.getDate("date_time"));
            receipt.setTotalPrice(resultSet.getDouble("total_price"));
            toReturn.add(receipt);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createReceipt(Receipt receipt) throws SQLException {
        String query = "insert into Receipt(employee_id, buyer_id, date_time, total_price)"
                + "values(?, ?, ?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, receipt.getEmployee().getPersonId());
        if(receipt.getBuyer() == null) {
            preparedStatement.setNull(2, Types.INTEGER);
        } else {
            preparedStatement.setInt(2, receipt.getBuyer().getPersonId());
        }
        preparedStatement.setDate(3, new java.sql.Date(receipt.getDateTime().getTime()));
        preparedStatement.setDouble(4, receipt.getTotalPrice());
        boolean status = preparedStatement.executeUpdate() == 1;
        var rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
             int autoIncKeyFromApi = rs.getInt(1);
             receipt.setId(autoIncKeyFromApi);
             rs.close();
        } else {

            // throw an exception from here
        }
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Receipt readReceipt(int id) throws SQLException {
        ArrayList<Receipt> receipts = this.GetAll();
        for(Receipt receipt : receipts){
            if(receipt.getId() == id){
                return receipt;
            }
        }
        return null;
    }

    @Override
    public boolean updateReceipt(Receipt receipt) throws SQLException {
        String query = "update Receipt set employee_id=?, buyer_id=?, date_time=?, total_price=? where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, receipt.getEmployee().getPersonId());
        preparedStatement.setInt(2, receipt.getBuyer().getPersonId());
        preparedStatement.setDate(3, new java.sql.Date(receipt.getDateTime().getTime()));
        preparedStatement.setDouble(4, receipt.getTotalPrice());
        preparedStatement.setInt(5, receipt.getId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteReceipt(int id) throws SQLException {
        String query = "delete from Receipt where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
