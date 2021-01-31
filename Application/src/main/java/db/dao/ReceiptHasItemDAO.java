package db.dao;

import db.dto.ReceiptHasItem;

import java.util.ArrayList;

public interface ReceiptHasItemDAO {
    public ArrayList<ReceiptHasItem> GetAll();
    public boolean createReceiptHasItem(ReceiptHasItem ReceiptHasItem);
    public ReceiptHasItem readReceiptHasItem(int id);
    public boolean updateReceiptHasItem(ReceiptHasItem ReceiptHasItem);
    public boolean deleteReceiptHasItem(int id);
}
