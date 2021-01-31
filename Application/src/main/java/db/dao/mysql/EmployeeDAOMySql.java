package db.dao.mysql;

import db.connection.ConnectionPool;
import db.dao.EmployeeDAO;
import db.dto.Accesories;
import db.dto.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOMySql implements EmployeeDAO {
    @Override
    public ArrayList<Employee> GetAll() throws SQLException {
        ArrayList<Employee> toReturn = new ArrayList<>();
        String query = "select person_id, address_id, employee_username, employee_password, first_name, last_name from "
                + "Employee inner join Person on Employee.person_id=Person.id";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            Employee employee = new Employee();
            employee.setPersonId(resultSet.getInt("person_id"));
            employee.setAddress(new AddressDAOMySql().readAddress(resultSet.getInt("address_id")));
            employee.setEmployeeUsername(resultSet.getString("employee_username"));
            employee.setEmployeePassword(resultSet.getString("employee_password"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            toReturn.add(employee);
        }
        ConnectionPool.releaseConnection(connection);
        return toReturn;
    }

    @Override
    public boolean createEmployee(Employee employee) throws SQLException {
        String query = "update Employee set employee_username=?, employee_password=? where person_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, employee.getEmployeeUsername());
        preparedStatement.setString(2, employee.getEmployeePassword());
        preparedStatement.setInt(3, employee.getPersonId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public Employee readEmployee(int id) throws SQLException {
        ArrayList<Employee> employees = this.GetAll();
        for(Employee employee : employees){
            if(employee.getPersonId() == id){
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        String query = "update Employee set address_id=?, employee_username=?, employee_password=? where person_id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, employee.getAddress().getId());
        preparedStatement.setString(2, employee.getEmployeeUsername());
        preparedStatement.setString(3, employee.getEmployeePassword());
        preparedStatement.setInt(4, employee.getPersonId());
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        String query = "delete from Employee where id=?";
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        boolean status = preparedStatement.execute();
        ConnectionPool.releaseConnection(connection);
        return status;
    }
}
