package db.dao.mysql;

import db.dao.PistolDAO;
import db.dto.Pistol;

import java.util.ArrayList;

public class PistolDAOMySql implements PistolDAO {
    @Override
    public ArrayList<Pistol> GetAll() {
        return null;
    }

    @Override
    public boolean createPistol(Pistol Pistol) {
        return false;
    }

    @Override
    public Pistol readPistol(int id) {
        return null;
    }

    @Override
    public boolean updatePistol(Pistol Pistol) {
        return false;
    }

    @Override
    public boolean deletePistol(int id) {
        return false;
    }
}
