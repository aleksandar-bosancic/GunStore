package db.dao.mysql;

import db.dao.AccesoriesDAO;
import db.dto.Accesories;

import java.util.ArrayList;

public class AccesoriesDAOMySql implements AccesoriesDAO {
    @Override
    public ArrayList<Accesories> GetAll() {
        return null;
    }

    @Override
    public boolean createAccesories(Accesories accesories) {
        return false;
    }

    @Override
    public Accesories readAccesories(int id) {
        return null;
    }

    @Override
    public boolean updateAccesories(Accesories accesories) {
        return false;
    }

    @Override
    public boolean deleteAccesories(int id) {
        return false;
    }
}
