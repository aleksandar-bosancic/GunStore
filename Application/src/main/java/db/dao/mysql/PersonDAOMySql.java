package db.dao.mysql;

import db.dao.PersonDAO;
import db.dto.Person;

import java.util.ArrayList;

public class PersonDAOMySql implements PersonDAO {
    @Override
    public ArrayList<Person> GetAll() {
        return null;
    }

    @Override
    public boolean createPerson(Person Person) {
        return false;
    }

    @Override
    public Person readPerson(int id) {
        return null;
    }

    @Override
    public boolean updatePerson(Person Person) {
        return false;
    }

    @Override
    public boolean deletePerson(int id) {
        return false;
    }
}
