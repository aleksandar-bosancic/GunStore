package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.PersonDAO;
import db.dto.Item;
import db.dto.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAOMySql implements PersonDAO {
    @Override
    public ArrayList<Person> GetAll() throws SQLException {
        ArrayList<Person> toReturn = new ArrayList<>();
        String query = "select id, first_name, last_name from Person";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Person person = new Person();
            person.setPersonId(resultSet.getInt("id"));
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            toReturn.add(person);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createPerson(Person person) throws SQLException {
        String query = "insert into Person(first_name, last_name)"
                + "values(?, ?)";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, person.getFirstName());
        preparedStatement.setString(2, person.getLastName());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Person readPerson(int id) throws SQLException {
        ArrayList<Person> people = this.GetAll();
        for(Person person : people){
            if(person.getPersonId() == id){
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean updatePerson(Person person) throws SQLException {
        String query = "update Person set first_name=?, last_name=? where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, person.getFirstName());
        preparedStatement.setString(2, person.getLastName());
        preparedStatement.setInt(3, person.getPersonId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deletePerson(int id) throws SQLException {
        String query = "delete from Person where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
