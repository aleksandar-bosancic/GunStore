package db.dao;

import db.dto.SportRifle;

import java.util.ArrayList;

public interface SportRifleDAO {
    public ArrayList<SportRifle> GetAll();
    public boolean createSportRifle(SportRifle SportRifle);
    public SportRifle readSportRifle(int id);
    public boolean updateSportRifle(SportRifle SportRifle);
    public boolean deleteSportRifle(int id);
}
