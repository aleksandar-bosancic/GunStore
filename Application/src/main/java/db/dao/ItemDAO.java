package db.dao;

import db.dto.Item;

import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<Item> GetAll();
    public boolean createItem(Item Item);
    public Item readItem(int id);
    public boolean updateItem(Item Item);
    public boolean deleteItem(int id);
}
