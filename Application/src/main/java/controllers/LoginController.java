package controllers;

import com.jfoenix.controls.*;
import com.sun.tools.javac.Main;
import db.dao.EmployeeDAO;
import db.dao.mysql.EmployeeDAOMySql;
import db.dto.Employee;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    private Employee loggedInEmployee = new Employee();
    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXTextField usernameTextField;


    private void showDialog(String title, String message){
        Alert dialog = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
        dialog.setTitle(title);
        dialog.setContentText(message);
        dialog.getDialogPane().getStylesheets().add(LoginController.class.getResource("../Style.css").toExternalForm());
        ((Stage)dialog.getDialogPane().getScene().getWindow()).initStyle(StageStyle.UNDECORATED);
        dialog.showAndWait();
    }

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
                            Stage mainStage = new Stage();
                            Parent root = loader.getRoot();
                            Scene mainScene = new Scene(root);
                            mainStage.setScene(mainScene);
                            mainStage.initStyle(StageStyle.TRANSPARENT);
                            usernameTextField.getScene().getWindow().hide();
                            mainStage.show();

                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                } else {
                    usernameTextField.clear();
                    passwordTextField.clear();
                    Platform.runLater(()->{ showDialog("Invalid login", "Entered credentials are invalid!"); });
                }

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }).start();
    }

    @FXML
    void loginActionKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            loginAction(null);
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
