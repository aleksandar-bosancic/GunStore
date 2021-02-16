package controllers;

import com.jfoenix.controls.JFXTextField;
import db.dao.mysql.FirearmPermitDAOMySql;
import db.dao.mysql.ItemDAOMySql;
import db.dao.mysql.ReceiptDAOMySql;
import db.dao.mysql.ReceiptHasItemDAOMySql;
import db.dto.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;


public class MainController {
    private ObservableList<Item> itemList = FXCollections.observableList(new ArrayList<>());
    private ObservableList<ReceiptHasItem> receiptHasItemsList = FXCollections.observableList(new ArrayList<>());
    private Receipt activeReceipt;
    private Buyer buyer;

    public void setLoggedInEmployee(Employee loggedInEmployee) {
        this.loggedInEmployee = loggedInEmployee;
    }

    private Employee loggedInEmployee = new Employee();

    @FXML
    private JFXTextField personIdTextField;

    @FXML
    private JFXTextField amountTextField;

    @FXML
    private TableView<Item> mainTable;

    @FXML
    private TableView<ReceiptHasItem> receiptTable;

    @FXML
    public Label totalPriceLabel;

    @FXML
    private void initialize() {
        TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter(),1);
        amountTextField.setTextFormatter(formatter);
        try {
            itemList.addAll(new ItemDAOMySql().GetAll());
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        mainTable.setItems(itemList);
        receiptTable.setItems(receiptHasItemsList);
    }

    private void showDialog(String title, String message){
        Alert dialog = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
        dialog.setTitle(title);
        dialog.setContentText(message);
        dialog.getDialogPane().getStylesheets().add(LoginController.class.getResource("../Style.css").toExternalForm());
        ((Stage)dialog.getDialogPane().getScene().getWindow()).initStyle(StageStyle.UNDECORATED);
        dialog.showAndWait();
    }

    public void addOnReceipt(ActionEvent actionEvent) {
        if(receiptHasItemsList.isEmpty()){
            activeReceipt = new Receipt();
        }
        if(buyer == null){
            buyer = new Buyer();
        }
        Item itemToAdd = mainTable.getSelectionModel().getSelectedItem();
        try {
            if(new FirearmPermitDAOMySql().requiresPermit(itemToAdd.getId())){
                if(personIdTextField.getText().equals("")){
                    showDialog("No person ID", "Please enter person ID!");
                } else {
                    buyer.setPersonId(Integer.parseInt(personIdTextField.getText()));
                    if(new FirearmPermitDAOMySql().checkFirearmPermit(buyer.getPersonId())){
                        addItemOnReceipt(itemToAdd);
                    } else {
                        buyer = null;
                        showDialog("No firearm permit", "Buyer does not have a valid firearm permit!");
                    }
                }
            } else {
                buyer = null;
                addItemOnReceipt(itemToAdd);
            }
        } catch (SQLException exception) {
            buyer = null;
            exception.printStackTrace();
        }
    }


    private void addItemOnReceipt(Item itemToAdd) {
        int amount = Integer.parseInt(amountTextField.getText());
        if(itemToAdd.getIn_stock() < amount){
            showDialog("Out of stock", "Amount of items in stock is not enough!");
            return;
        }
        boolean hadSame = false;
        for(int i = 0; i < receiptHasItemsList.size(); i++){
            if(receiptHasItemsList.get(i).getItem().equals(itemToAdd)){
                receiptHasItemsList.get(i).setAmount(receiptHasItemsList.get(i).getAmount() + amount);
                receiptHasItemsList.get(i).setItemPrice(receiptHasItemsList.get(i).getAmount() * receiptHasItemsList.get(i).getItem().getPrice());
                receiptTable.refresh();
                hadSame = true;
                break;
            }
        }
        if(!hadSame) {
            ReceiptHasItem receiptHasItem = new ReceiptHasItem();
            receiptHasItem.setItem(itemToAdd);
            receiptHasItem.setReceipt(activeReceipt);
            receiptHasItem.setAmount(amount);
            receiptHasItem.setItemPrice(amount * itemToAdd.getPrice());
            receiptHasItemsList.add(receiptHasItem);
        }

        totalPriceLabel.setText(String.valueOf(receiptHasItemsList.stream().mapToDouble(ReceiptHasItem::getItemPrice).sum()));
    }

    public void checkout(ActionEvent actionEvent) {
        if(buyer != null){
            buyer.setPersonId(Integer.parseInt(personIdTextField.getText()));
            activeReceipt.setBuyer(buyer);
        }
        activeReceipt.setEmployee(loggedInEmployee);
        activeReceipt.setDateTime(Date.from(Instant.now()));
        ReceiptDAOMySql receiptDAOMySql = new ReceiptDAOMySql();
        try {
            receiptDAOMySql.createReceipt(activeReceipt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        ReceiptHasItemDAOMySql receiptHasItemDAOMySql = new ReceiptHasItemDAOMySql();
        receiptHasItemsList.forEach(receiptHasItem -> {
            try {
                receiptHasItemDAOMySql.createReceiptHasItem(receiptHasItem);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        try {
            itemList.clear();
            itemList.addAll(new ItemDAOMySql().GetAll());
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        receiptHasItemsList.clear();
        totalPriceLabel.setText("");
        activeReceipt = null;
        buyer = null;
    }

    public void clearReceipt(ActionEvent actionEvent) {
        receiptHasItemsList.clear();
        totalPriceLabel.setText("");
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

}