package db.dao;

import db.dto.MunitionType;

import java.util.ArrayList;

public interface MunitionTypeDAO {
    public ArrayList<MunitionType> GetAll();
    public boolean createMunitionType(MunitionType MunitionType);
    public MunitionType readMunitionType(int id);
    public boolean updateMunitionType(MunitionType MunitionType);
    public boolean deleteMunitionType(int id);
}
