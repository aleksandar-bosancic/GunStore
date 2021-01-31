package db.dao.mysql;

import db.dao.SportRifleDAO;
import db.dto.SportRifle;

import java.util.ArrayList;

public class SportRifleDAOMySql implements SportRifleDAO {
    @Override
    public ArrayList<SportRifle> GetAll() {
        return null;
    }

    @Override
    public boolean createSportRifle(SportRifle SportRifle) {
        return false;
    }

    @Override
    public SportRifle readSportRifle(int id) {
        return null;
    }

    @Override
    public boolean updateSportRifle(SportRifle SportRifle) {
        return false;
    }

    @Override
    public boolean deleteSportRifle(int id) {
        return false;
    }
}
