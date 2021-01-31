package db.dao.mysql;

import db.dao.GasPistolDAO;
import db.dto.GasPistol;

import java.util.ArrayList;

public class GasPistolDAOMySql implements GasPistolDAO {
    @Override
    public ArrayList<GasPistol> GetAll() {
        return null;
    }

    @Override
    public boolean createGasPistol(GasPistol GasPistol) {
        return false;
    }

    @Override
    public GasPistol readGasPistol(int id) {
        return null;
    }

    @Override
    public boolean updateGasPistol(GasPistol GasPistol) {
        return false;
    }

    @Override
    public boolean deleteGasPistol(int id) {
        return false;
    }
}
