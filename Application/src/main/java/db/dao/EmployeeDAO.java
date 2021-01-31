package db.dao;

import db.dto.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
    public ArrayList<Employee> GetAll() throws SQLException;
    public boolean createEmployee(Employee employee) throws SQLException;
    public Employee readEmployee(int id) throws SQLException;
    public boolean updateEmployee(Employee employee) throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
}
