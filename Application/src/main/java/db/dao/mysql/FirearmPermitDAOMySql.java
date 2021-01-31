package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.FirearmPermitDAO;
import db.dto.FirearmPermit;
import db.dto.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FirearmPermitDAOMySql implements FirearmPermitDAO {
    @Override
    public ArrayList<FirearmPermit> GetAll() throws SQLException {
        ArrayList<FirearmPermit> toReturn = new ArrayList<>();
        String query = "select id, issue_date, expiration_date from Firearm_Permit";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            FirearmPermit firearmPermit = new FirearmPermit();
            firearmPermit.setFirearmPermitId(resultSet.getString("id"));
            firearmPermit.setIssueDate(resultSet.getDate("issue_date"));
            firearmPermit.setExpirationDate(resultSet.getDate("expiration_date"));
            toReturn.add(firearmPermit);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createFirearmPermit(FirearmPermit firearmPermit) throws SQLException {
        String query = "insert into Firearm_Permit(id, issue_date, expiration_date)"
                + "values(?, ?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, firearmPermit.getFirearmPermitId());
        preparedStatement.setDate(2, new java.sql.Date(firearmPermit.getIssueDate().getTime()));
        preparedStatement.setDate(3, new java.sql.Date(firearmPermit.getExpirationDate().getTime()));
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public FirearmPermit readFirearmPermit(String id) throws SQLException {
        ArrayList<FirearmPermit> firearmPermits = this.GetAll();
        for(FirearmPermit firearmPermit : firearmPermits){
            if(firearmPermit.getFirearmPermitId().equals(id)){
                return firearmPermit;
            }
        }
        return null;
    }

    @Override
    public boolean updateFirearmPermit(FirearmPermit firearmPermit) throws SQLException {
        String query = "update Firearm_Permit set issue_date=?, expiration_date=? where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);;
        preparedStatement.setDate(1, new java.sql.Date(firearmPermit.getIssueDate().getTime()));
        preparedStatement.setDate(2, new java.sql.Date(firearmPermit.getExpirationDate().getTime()));
        preparedStatement.setString(3, firearmPermit.getFirearmPermitId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteFirearmPermit(String id) throws SQLException {
        String query = "delete from Firearm_Permit where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
