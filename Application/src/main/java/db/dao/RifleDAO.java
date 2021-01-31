package db.dao;

import db.dto.Rifle;

import java.util.ArrayList;

public interface RifleDAO {
    public ArrayList<Rifle> GetAll();
    public boolean createRifle(Rifle Rifle);
    public Rifle readRifle(int id);
    public boolean updateRifle(Rifle Rifle);
    public boolean deleteRifle(int id);
}
