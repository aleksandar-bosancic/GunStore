package db.dao;

import db.dto.FirearmRifle;

import java.util.ArrayList;

public interface FirearmRifleDAO {
    public ArrayList<FirearmRifle> GetAll();
    public boolean createFirearmRifle(FirearmRifle FirearmRifle);
    public FirearmRifle readFirearmRifle(int id);
    public boolean updateFirearmRifle(FirearmRifle FirearmRifle);
    public boolean deleteFirearmRifle(int id);
}
