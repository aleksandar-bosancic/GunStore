package db.dao.mysql;

import db.dao.MunitionTypeDAO;
import db.dto.MunitionType;

import java.util.ArrayList;

public class MunitionTypeDAOMySql implements MunitionTypeDAO {
    @Override
    public ArrayList<MunitionType> GetAll() {
        return null;
    }

    @Override
    public boolean createMunitionType(MunitionType MunitionType) {
        return false;
    }

    @Override
    public MunitionType readMunitionType(int id) {
        return null;
    }

    @Override
    public boolean updateMunitionType(MunitionType MunitionType) {
        return false;
    }

    @Override
    public boolean deleteMunitionType(int id) {
        return false;
    }
}
