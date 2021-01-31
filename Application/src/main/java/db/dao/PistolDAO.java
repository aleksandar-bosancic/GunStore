package db.dao;

import db.dto.Pistol;

import java.util.ArrayList;

public interface PistolDAO {
    public ArrayList<Pistol> GetAll();
    public boolean createPistol(Pistol Pistol);
    public Pistol readPistol(int id);
    public boolean updatePistol(Pistol Pistol);
    public boolean deletePistol(int id);
}
