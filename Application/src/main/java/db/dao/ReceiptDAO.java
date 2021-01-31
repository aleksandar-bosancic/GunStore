package db.dao;

import db.dto.Receipt;

import java.util.ArrayList;

public interface ReceiptDAO {
    public ArrayList<Receipt> GetAll();
    public boolean createReceipt(Receipt Receipt);
    public Receipt readReceipt(int id);
    public boolean updateReceipt(Receipt Receipt);
    public boolean deleteReceipt(int id);
}
