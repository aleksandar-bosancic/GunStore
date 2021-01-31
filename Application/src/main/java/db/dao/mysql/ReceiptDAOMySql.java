package db.dao.mysql;

import db.dao.ReceiptDAO;
import db.dto.Receipt;

import java.util.ArrayList;

public class ReceiptDAOMySql implements ReceiptDAO {
    @Override
    public ArrayList<Receipt> GetAll() {
        return null;
    }

    @Override
    public boolean createReceipt(Receipt Receipt) {
        return false;
    }

    @Override
    public Receipt readReceipt(int id) {
        return null;
    }

    @Override
    public boolean updateReceipt(Receipt Receipt) {
        return false;
    }

    @Override
    public boolean deleteReceipt(int id) {
        return false;
    }
}
