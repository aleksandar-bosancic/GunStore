package db.dao;

import db.dto.FirearmPistol;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FirearmPistolDAO {
    public ArrayList<FirearmPistol> GetAll() throws SQLException;
    public boolean createFirearmPistol(FirearmPistol FirearmPistol) throws SQLException;
    public FirearmPistol readFirearmPistol(int id) throws SQLException;
    public boolean updateFirearmPistol(FirearmPistol FirearmPistol);
    public boolean deleteFirearmPistol(int id) throws SQLException;
}
