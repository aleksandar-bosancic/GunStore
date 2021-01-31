package db.dao;

import db.dto.FirearmPermit;

import java.util.ArrayList;

public interface FirearmPermitDAO {
    public ArrayList<FirearmPermit> GetAll();
    public boolean createFirearmPermit(FirearmPermit FirearmPermit);
    public FirearmPermit readFirearmPermit(int id);
    public boolean updateFirearmPermit(FirearmPermit FirearmPermit);
    public boolean deleteFirearmPermit(int id);
}
