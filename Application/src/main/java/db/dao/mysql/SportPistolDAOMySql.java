package db.dao.mysql;

import db.dao.SportPistolDAO;
import db.dto.SportPistol;

import java.util.ArrayList;

public class SportPistolDAOMySql implements SportPistolDAO {
    @Override
    public ArrayList<SportPistol> GetAll() {
        return null;
    }

    @Override
    public boolean createSportPistol(SportPistol SportPistol) {
        return false;
    }

    @Override
    public SportPistol readSportPistol(int id) {
        return null;
    }

    @Override
    public boolean updateSportPistol(SportPistol SportPistol) {
        return false;
    }

    @Override
    public boolean deleteSportPistol(int id) {
        return false;
    }
}
