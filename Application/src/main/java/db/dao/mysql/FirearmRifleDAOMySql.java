package db.dao.mysql;

import db.dao.FirearmRifleDAO;
import db.dto.FirearmRifle;

import java.util.ArrayList;

public class FirearmRifleDAOMySql implements FirearmRifleDAO {
    @Override
    public ArrayList<FirearmRifle> GetAll() {
        return null;
    }

    @Override
    public boolean createFirearmRifle(FirearmRifle FirearmRifle) {
        return false;
    }

    @Override
    public FirearmRifle readFirearmRifle(int id) {
        return null;
    }

    @Override
    public boolean updateFirearmRifle(FirearmRifle FirearmRifle) {
        return false;
    }

    @Override
    public boolean deleteFirearmRifle(int id) {
        return false;
    }
}
