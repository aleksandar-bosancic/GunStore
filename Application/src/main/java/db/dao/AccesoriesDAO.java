package db.dao;

import db.dto.Accesories;

import java.util.ArrayList;

public interface AccesoriesDAO {
    public ArrayList<Accesories> GetAll();
    public boolean createAccesories(Accesories accesories);
    public Accesories readAccesories(int id);
    public boolean updateAccesories(Accesories accesories);
    public boolean deleteAccesories(int id);
}
