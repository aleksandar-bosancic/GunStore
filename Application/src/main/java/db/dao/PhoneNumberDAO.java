package db.dao;

import db.dto.PhoneNumber;

import java.util.ArrayList;

public interface PhoneNumberDAO {
    public ArrayList<PhoneNumber> GetAll();
    public boolean createPhoneNumber(PhoneNumber PhoneNumber);
    public PhoneNumber readPhoneNumber(int id);
    public boolean updatePhoneNumber(PhoneNumber PhoneNumber);
    public boolean deletePhoneNumber(int id);
}
