package db.dao;

import db.dto.GasPistol;

import java.util.ArrayList;

public interface GasPistolDAO {
    public ArrayList<GasPistol> GetAll();
    public boolean createGasPistol(GasPistol GasPistol);
    public GasPistol readGasPistol(int id);
    public boolean updateGasPistol(GasPistol GasPistol);
    public boolean deleteGasPistol(int id);
}
