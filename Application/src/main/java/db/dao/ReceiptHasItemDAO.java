package db.dao;

import db.dto.ReceiptHasItem;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReceiptHasItemDAO {
    public ArrayList<ReceiptHasItem> GetAll() throws SQLException;
    public boolean createReceiptHasItem(ReceiptHasItem receiptHasItem) throws SQLException;
    public ReceiptHasItem readReceiptHasItem(int receipt_id, int item_id) throws SQLException;
    public boolean updateReceiptHasItem(ReceiptHasItem receiptHasItem) throws SQLException;
    public boolean deleteReceiptHasItem(int receipt_id, int item_id) throws SQLException;
}
