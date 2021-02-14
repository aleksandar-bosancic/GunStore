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
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.converter.IntegerStringConverter;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


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
    private void initialize() {
        TextFormatter<Integer> formatter = new TextFormatter<>(
                new IntegerStringConverter(), // Standard converter form JavaFX
                0);

        amountTextField.setTextFormatter(formatter);
        try {
            itemList.addAll(new ItemDAOMySql().GetAll());
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        mainTable.setItems(itemList);
        receiptTable.setItems(receiptHasItemsList);
    }

    public void addOnReceipt(ActionEvent actionEvent) {
        if(receiptHasItemsList.isEmpty()){
            activeReceipt = new Receipt();
        }
        Item itemToAdd = mainTable.getSelectionModel().getSelectedItem();
        try {
            if(new FirearmPermitDAOMySql().requiresPermit(itemToAdd.getId())){
                buyer = new Buyer();
                buyer.setPersonId(Integer.parseInt(personIdTextField.getText()));
                if(new FirearmPermitDAOMySql().requiresPermit(itemToAdd.getId())){
                    addItemOnReceipt(itemToAdd);
                } else {
                    buyer = null;
                    //TODO valja se napraviti nesto.
                }
            } else {
                addItemOnReceipt(itemToAdd);
            }

        } catch (SQLException exception) {
            buyer = null;
            exception.printStackTrace();
        }
    }

    private void addItemOnReceipt(Item itemToAdd) {
        int amount = Integer.parseInt(amountTextField.getText());
        ReceiptHasItem receiptHasItem = new ReceiptHasItem();
        receiptHasItem.setItem(itemToAdd);
        receiptHasItem.setReceipt(activeReceipt);
        receiptHasItem.setAmount(amount);
        receiptHasItem.setItemPrice(itemToAdd.getPrice()*amount);
        receiptHasItemsList.add(receiptHasItem);
    }

    public void checkout(ActionEvent actionEvent) {
        if(buyer != null){
            buyer.setPersonId(Integer.parseInt(personIdTextField.getText()));
            activeReceipt.setBuyer(buyer);
        }
        activeReceipt.setEmployee(loggedInEmployee);
        activeReceipt.setDateTime(Date.from(Instant.now()));
//        activeReceipt.setTotalPrice(receiptHasItemsList.stream().mapToDouble(ReceiptHasItem::getItemPrice).sum());
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
        buyer = null;
    }
}