package db.dao.mysql;

import db.dao.ItemDAO;
import db.dto.Item;

import java.util.ArrayList;

public class ItemDAOMySql implements ItemDAO {
    @Override
    public ArrayList<Item> GetAll() {
        return null;
    }

    @Override
    public boolean createItem(Item Item) {
        return false;
    }

    @Override
    public Item readItem(int id) {
        return null;
    }

    @Override
    public boolean updateItem(Item Item) {
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        return false;
    }
}
