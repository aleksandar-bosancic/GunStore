package db.dao.mysql;

import db.dao.RifleDAO;
import db.dto.Rifle;

import java.util.ArrayList;

public class RifleDAOMySql implements RifleDAO {
    @Override
    public ArrayList<Rifle> GetAll() {
        return null;
    }

    @Override
    public boolean createRifle(Rifle Rifle) {
        return false;
    }

    @Override
    public Rifle readRifle(int id) {
        return null;
    }

    @Override
    public boolean updateRifle(Rifle Rifle) {
        return false;
    }

    @Override
    public boolean deleteRifle(int id) {
        return false;
    }
}
