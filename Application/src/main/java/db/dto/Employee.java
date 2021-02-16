package db.dto;

import java.util.Objects;

public class Employee extends Person{
    private Address address;
    private String employeeUsername;
    private String employeePassword;

    public void setAddressId(int id) {
        address.setId(id);
    }

    public int getAddressId() {
        return getAddress().getId();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(address, employee.address) && Objects.equals(employeeUsername, employee.employeeUsername) && Objects.equals(employeePassword, employee.employeePassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, employeeUsername, employeePassword);
    }
}
