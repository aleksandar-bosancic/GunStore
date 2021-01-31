package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.BuyerDAO;
import db.dto.Buyer;
import db.dto.Employee;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BuyerDAOMySql implements BuyerDAO {
    @Override
    public ArrayList<Buyer> GetAll() throws SQLException {
        ArrayList<Buyer> toReturn = new ArrayList<>();
        String query = "select person_id, firearm_permit_id, first_name, last_name from "
                + "Buyer inner join Person on Buyer.person_id=Person.id";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Buyer buyer = new Buyer();
            buyer.setPersonId(resultSet.getInt("person_id"));
            buyer.setFirearmPermit(new FirearmPermitDAOMySql().readFirearmPermit(resultSet.getString("firearm_permit_id")));
            buyer.setFirstName(resultSet.getString("first_name"));
            buyer.setLastName(resultSet.getString("last_name"));
            toReturn.add(buyer);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createBuyer(Buyer buyer) throws SQLException {
        String query = "insert into Buyer(person_id, firearm_permit_id) "
                + "values(?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, buyer.getPersonId());
        preparedStatement.setString(2, buyer.getFirearmPermit().getFirearmPermitId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Buyer readBuyer(int id) {
        ArrayList<Buyer> buyers = new ArrayList<>();
        for(Buyer buyer : buyers){
            if(buyer.getPersonId() == id){
                return buyer;
            }
        }
        return null;
    }

    @Override
    public boolean updateBuyer(Buyer buyer) throws SQLException {
        String query = "update Buyer set firearm_permit_id=? where person_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, buyer.getFirearmPermit().getFirearmPermitId());
        preparedStatement.setInt(2, buyer.getPersonId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteBuyer(int id) throws SQLException {
        String query = "delete from Buyer where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
