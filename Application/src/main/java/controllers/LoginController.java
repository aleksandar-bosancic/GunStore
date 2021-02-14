package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.tools.javac.Main;
import db.dao.EmployeeDAO;
import db.dao.mysql.EmployeeDAOMySql;
import db.dto.Employee;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    private Employee loggedInEmployee = new Employee();
    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private void loginAction(ActionEvent actionEvent){
        EmployeeDAO employeeDAO = new EmployeeDAOMySql();
        new Thread(()->{
            try {
                if(employeeDAO.login(usernameTextField.getText(), passwordTextField.getText())){
                    loggedInEmployee = employeeDAO.readEmployee(usernameTextField.getText());
                    Platform.runLater(()->{
                        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Main_scene.fxml"));
                        try {
                            loader.load();
                            ((MainController)loader.getController()).setLoggedInEmployee(loggedInEmployee);
                            Parent root = loader.getRoot();
                            ((Stage) usernameTextField.getScene().getWindow()).setScene(new Scene(root));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                }

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }).start();
    }
}
