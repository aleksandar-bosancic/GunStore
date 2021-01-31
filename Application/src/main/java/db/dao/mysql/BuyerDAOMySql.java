package db.dao.mysql;

import db.dao.BuyerDAO;
import db.dto.Buyer;

import java.util.ArrayList;

public class BuyerDAOMySql implements BuyerDAO {
    @Override
    public ArrayList<Buyer> GetAll() {
        return null;
    }

    @Override
    public boolean createBuyer(Buyer Buyer) {
        return false;
    }

    @Override
    public Buyer readBuyer(int id) {
        return null;
    }

    @Override
    public boolean updateBuyer(Buyer Buyer) {
        return false;
    }

    @Override
    public boolean deleteBuyer(int id) {
        return false;
    }
}
