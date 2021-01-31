package db.dao;

import db.dto.Accesories;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AccesoriesDAO {
    public ArrayList<Accesories> GetAll() throws SQLException;
    public boolean createAccesories(Accesories accesories) throws SQLException;
    public Accesories readAccesories(int id) throws SQLException;
    public boolean updateAccesories(Accesories accesories) throws SQLException;
    public boolean deleteAccesories(int id) throws SQLException;
}
