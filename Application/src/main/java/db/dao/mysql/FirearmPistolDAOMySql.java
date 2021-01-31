package db.dao.mysql;

import db.dao.FirearmPistolDAO;
import db.dto.FirearmPistol;

import java.util.ArrayList;

public class FirearmPistolDAOMySql implements FirearmPistolDAO {
    @Override
    public ArrayList<FirearmPistol> GetAll() {
        return null;
    }

    @Override
    public boolean createFirearmPistol(FirearmPistol FirearmPistol) {
        return false;
    }

    @Override
    public FirearmPistol readFirearmPistol(int id) {
        return null;
    }

    @Override
    public boolean updateFirearmPistol(FirearmPistol FirearmPistol) {
        return false;
    }

    @Override
    public boolean deleteFirearmPistol(int id) {
        return false;
    }
}
