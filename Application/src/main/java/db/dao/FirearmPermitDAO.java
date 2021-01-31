package db.dao;

import db.dto.FirearmPermit;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FirearmPermitDAO {
    public ArrayList<FirearmPermit> GetAll() throws SQLException;
    public boolean createFirearmPermit(FirearmPermit firearmPermit) throws SQLException;
    public FirearmPermit readFirearmPermit(String id) throws SQLException;
    public boolean updateFirearmPermit(FirearmPermit firearmPermit) throws SQLException;
    public boolean deleteFirearmPermit(String id) throws SQLException;
}
