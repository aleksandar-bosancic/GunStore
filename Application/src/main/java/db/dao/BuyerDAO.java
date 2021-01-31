package db.dao;

import db.dto.Buyer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BuyerDAO {
    public ArrayList<Buyer> GetAll() throws SQLException;
    public boolean createBuyer(Buyer buyer) throws SQLException;
    public Buyer readBuyer(int id);
    public boolean updateBuyer(Buyer buyer) throws SQLException;
    public boolean deleteBuyer(int id) throws SQLException;
}
