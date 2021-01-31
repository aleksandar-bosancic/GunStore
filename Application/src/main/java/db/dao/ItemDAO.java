package db.dao;

import db.dto.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<Item> GetAll() throws SQLException;
    public boolean createItem(Item item) throws SQLException;
    public Item readItem(int id) throws SQLException;
    public boolean updateItem(Item item) throws SQLException;
    public boolean deleteItem(int id) throws SQLException;
}
