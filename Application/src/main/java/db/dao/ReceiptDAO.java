package db.dao;

import db.dto.Receipt;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReceiptDAO {
    public ArrayList<Receipt> GetAll() throws SQLException;
    public boolean createReceipt(Receipt receipt) throws SQLException;
    public Receipt readReceipt(int id) throws SQLException;
    public boolean updateReceipt(Receipt receipt) throws SQLException;
    public boolean deleteReceipt(int id) throws SQLException;
}
