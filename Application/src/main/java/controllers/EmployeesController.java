package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.dao.AddressDAO;
import db.dao.mysql.AddressDAOMySql;
import db.dao.mysql.EmployeeDAOMySql;
import db.dao.mysql.PersonDAOMySql;
import db.dto.Address;
import db.dto.Employee;
import db.dto.Person;
import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesController {
    private int employeeId;
    private Address employeeAddress;
    private Person person;
    private Employee employee;
    private EmployeeDAOMySql employeeDAOMySql;
    private AddressDAOMySql addressDAOMySql;
    private PersonDAOMySql personDAOMySql;

    @FXML
    public JFXButton updateButton;

    @FXML
    public JFXButton deleteButton;

    @FXML
    public JFXTextField nameTextField;

    @FXML
    public JFXTextField lastNameTextField;

    @FXML
    public JFXTextField usernameTextField;

    @FXML
    public JFXTextField passwordTextField;

    @FXML
    public JFXTextField searchIdTextField;

    @FXML
    public JFXTextField addressTextField;

    @FXML
    private void initialize(){
        updateButton.setDisable(true);
        deleteButton.setDisable(true);
        TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
        searchIdTextField.setTextFormatter(formatter);
        personDAOMySql = new PersonDAOMySql();
        employeeDAOMySql = new EmployeeDAOMySql();
        addressDAOMySql = new AddressDAOMySql();
        employee = new Employee();
    }

    private void showDialog(String title, String message){
        Platform.runLater(()->{
            Alert dialog = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
            dialog.setTitle(title);
            dialog.setContentText(message);
            dialog.getDialogPane().getStylesheets().add(LoginController.class.getResource("../Style.css").toExternalForm());
            ((Stage)dialog.getDialogPane().getScene().getWindow()).initStyle(StageStyle.UNDECORATED);
            ((Stage) dialog.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
            dialog.showAndWait();
        });
    }

    public void delete(ActionEvent actionEvent) {
        try {
            if(employeeDAOMySql.deleteEmployee(employeeId)){
                showDialog("Can not delete employee", "Can not delete employee from database!");
            } else {
                showDialog("Employee deleted", "Employee " + employee.getEmployeeUsername() + " successfully deleted.");
            }
            resetUI();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    //TODO dovrsi ovo!
    public void update(ActionEvent actionEvent) {
        if(checkTextFields()){
            employee.setEmployeeUsername(usernameTextField.getText());
            employee.setEmployeePassword(passwordTextField.getText());
            employeeAddress = new Address();
            Employee employeeInDatabase = new Employee();
            try {
                if(!searchIdTextField.getText().isEmpty()) {
                    employeeInDatabase = employeeDAOMySql.readEmployee(Integer.parseInt(searchIdTextField.getText()));
                    employeeAddress = setAddressFromString(addressTextField.getText());
                    if(!employeeInDatabase.getAddress().equals(employeeAddress)){
                        addressDAOMySql.createAddress(employeeAddress);
                    }


                }
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        } else {
            showDialog("Empty fields", "Please enter all required data.");
        }
    }

    public void add(ActionEvent actionEvent) {
        if(checkTextFields()){
            if(employee == null){
                employee = new Employee();
            }
            person  = new Person();
            employeeAddress = new Address();
            employeeAddress = setAddressFromString(addressTextField.getText());
            employee.setFirstName(nameTextField.getText());
            employee.setLastName(lastNameTextField.getText());
            employee.setEmployeeUsername(usernameTextField.getText());
            employee.setEmployeePassword(passwordTextField.getText());
            employee.setAddress(employeeAddress);
            person.setFirstName(nameTextField.getText());
            person.setLastName(lastNameTextField.getText());
                new Thread(()->{
                    try {
                        addressDAOMySql.createAddress(employeeAddress);
                        personDAOMySql.createPerson(person);
                        employee.setPersonId(person.getPersonId());
                        employee.setAddressId(employeeAddress.getId());
                        for (var employeeIterator : employeeDAOMySql.GetAll()) {
                            if(employeeIterator.equals(employee)){
                                Platform.runLater(()-> showDialog("Employee already exists", "Employee with same credentials already exists!"));
                                resetUI();
                                return;
                            }
                        }
                        employeeDAOMySql.createEmployee(employee);
                        showDialog("Successfully added", "Employee " + employee.getEmployeeUsername() + " successfully added.");
                        resetUI();
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                }).start();
        } else {
            showDialog("Empty fields", "Please enter all required data.");
        }
    }

    public void find(ActionEvent actionEvent) {
        if(!searchIdTextField.getText().equals("")){
            employeeId = Integer.parseInt(searchIdTextField.getText());
            try {
                employee = employeeDAOMySql.readEmployee(employeeId);
                if(employee == null){
                    showDialog("Invalid employee ID", "Enter valid employee ID!");
                    resetUI();
                    return;
                }
                employeeAddress = employee.getAddress();
                nameTextField.setText(employee.getFirstName());
                lastNameTextField.setText(employee.getLastName());
                usernameTextField.setText(employee.getEmployeeUsername());
                passwordTextField.setText(employee.getEmployeePassword());
                addressTextField.setText(returnAddressString(employeeAddress));
                updateButton.setDisable(false);
                deleteButton.setDisable(false);
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        } else {
            showDialog("Invalid employee ID", "Enter valid employee ID!");
        }
    }

    private boolean checkTextFields(){
        return !usernameTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty()
                && !nameTextField.getText().isEmpty() && !lastNameTextField.getText().isEmpty()
                && !addressTextField.getText().isEmpty();
    }

    public void resetUI(){
        Platform.runLater(()->{
            updateButton.setDisable(true);
            deleteButton.setDisable(true);
            nameTextField.clear();
            lastNameTextField.clear();
            usernameTextField.clear();
            passwordTextField.clear();
            searchIdTextField.clear();
            addressTextField.clear();
        });
    }

    private Address setAddressFromString(String addressString){
        Address address = new Address();
        String[] addressSplit = addressString.split(", ");
        address.setCity(addressSplit[0]);
        address.setStreet(addressSplit[1]);
        address.setNumber(Integer.parseInt(addressSplit[2]));
        return address;
    }

    private String returnAddressString(Address address){
        return (address.getCity() + ", " + address.getStreet() + ", " + address.getNumber());
    }

    public void exit(ActionEvent event) {
        nameTextField.getScene().getWindow().hide();
    }
}
