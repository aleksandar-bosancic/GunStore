package db.dao.mysql;

import db.dao.ReceiptHasItemDAO;
import db.dto.ReceiptHasItem;

import java.util.ArrayList;

public class ReceiptHasItemDAOMySql implements ReceiptHasItemDAO {
    @Override
    public ArrayList<ReceiptHasItem> GetAll() {
        return null;
    }

    @Override
    public boolean createReceiptHasItem(ReceiptHasItem ReceiptHasItem) {
        return false;
    }

    @Override
    public ReceiptHasItem readReceiptHasItem(int id) {
        return null;
    }

    @Override
    public boolean updateReceiptHasItem(ReceiptHasItem ReceiptHasItem) {
        return false;
    }

    @Override
    public boolean deleteReceiptHasItem(int id) {
        return false;
    }
}
