package db.dao.mysql;

import db.dao.FirearmPermitDAO;
import db.dto.FirearmPermit;

import java.util.ArrayList;

public class FirearmPermitDAOMySql implements FirearmPermitDAO {
    @Override
    public ArrayList<FirearmPermit> GetAll() {
        return null;
    }

    @Override
    public boolean createFirearmPermit(FirearmPermit FirearmPermit) {
        return false;
    }

    @Override
    public FirearmPermit readFirearmPermit(int id) {
        return null;
    }

    @Override
    public boolean updateFirearmPermit(FirearmPermit FirearmPermit) {
        return false;
    }

    @Override
    public boolean deleteFirearmPermit(int id) {
        return false;
    }
}
