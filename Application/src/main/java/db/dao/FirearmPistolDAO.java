package db.dao;

import db.dto.FirearmPistol;

import java.util.ArrayList;

public interface FirearmPistolDAO {
    public ArrayList<FirearmPistol> GetAll();
    public boolean createFirearmPistol(FirearmPistol FirearmPistol);
    public FirearmPistol readFirearmPistol(int id);
    public boolean updateFirearmPistol(FirearmPistol FirearmPistol);
    public boolean deleteFirearmPistol(int id);
}
