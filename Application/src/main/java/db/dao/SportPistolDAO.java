package db.dao;

import db.dto.SportPistol;

import java.util.ArrayList;

public interface SportPistolDAO {
    public ArrayList<SportPistol> GetAll();
    public boolean createSportPistol(SportPistol SportPistol);
    public SportPistol readSportPistol(int id);
    public boolean updateSportPistol(SportPistol SportPistol);
    public boolean deleteSportPistol(int id);
}
