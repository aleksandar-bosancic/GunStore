package db.dao;

import db.dto.Buyer;

import java.util.ArrayList;

public interface BuyerDAO {
    public ArrayList<Buyer> GetAll();
    public boolean createBuyer(Buyer Buyer);
    public Buyer readBuyer(int id);
    public boolean updateBuyer(Buyer Buyer);
    public boolean deleteBuyer(int id);
}
