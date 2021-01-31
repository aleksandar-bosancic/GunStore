package db.dao.mysql;

import db.dao.EmployeeDAO;
import db.dto.Employee;

import java.util.ArrayList;

public class EmployeeDAOMySql implements EmployeeDAO {
    @Override
    public ArrayList<Employee> GetAll() {
        return null;
    }

    @Override
    public boolean createEmployee(Employee Employee) {
        return false;
    }

    @Override
    public Employee readEmployee(int id) {
        return null;
    }

    @Override
    public boolean updateEmployee(Employee Employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }
}
