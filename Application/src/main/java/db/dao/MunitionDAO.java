package db.dao;

import db.dto.Munition;

import java.util.ArrayList;

public interface MunitionDAO {
    public ArrayList<Munition> GetAll();
    public boolean createMunition(Munition Munition);
    public Munition readMunition(int id);
    public boolean updateMunition(Munition Munition);
    public boolean deleteMunition(int id);
}
