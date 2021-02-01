package db.dao;

import db.dto.Pistol;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PistolDAO {
    public ArrayList<Pistol> GetAll() throws SQLException;
    public boolean createPistol(Pistol pistol) throws SQLException;
    public Pistol readPistol(int id) throws SQLException;
    public boolean updatePistol(Pistol pistol) throws SQLException;
    public boolean deletePistol(int id) throws SQLException;
}
