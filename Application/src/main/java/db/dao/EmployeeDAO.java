package db.dao;

import db.dto.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    public ArrayList<Employee> GetAll();
    public boolean createEmployee(Employee Employee);
    public Employee readEmployee(int id);
    public boolean updateEmployee(Employee Employee);
    public boolean deleteEmployee(int id);
}
