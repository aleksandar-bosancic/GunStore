package db.dao.mysql;

import db.dao.MunitionDAO;
import db.dto.Munition;

import java.util.ArrayList;

public class MunitionDAOMySql implements MunitionDAO{
    @Override
    public ArrayList<Munition> GetAll() {
        return null;
    }

    @Override
    public boolean createMunition(Munition Munition) {
        return false;
    }

    @Override
    public Munition readMunition(int id) {
        return null;
    }

    @Override
    public boolean updateMunition(Munition Munition) {
        return false;
    }

    @Override
    public boolean deleteMunition(int id) {
        return false;
    }
}
