package db.dao.mysql;

import db.dao.PhoneNumberDAO;
import db.dto.PhoneNumber;

import java.util.ArrayList;

public class PhoneNumberDAOMySql implements PhoneNumberDAO {
    @Override
    public ArrayList<PhoneNumber> GetAll() {
        return null;
    }

    @Override
    public boolean createPhoneNumber(PhoneNumber PhoneNumber) {
        return false;
    }

    @Override
    public PhoneNumber readPhoneNumber(int id) {
        return null;
    }

    @Override
    public boolean updatePhoneNumber(PhoneNumber PhoneNumber) {
        return false;
    }

    @Override
    public boolean deletePhoneNumber(int id) {
        return false;
    }
}
