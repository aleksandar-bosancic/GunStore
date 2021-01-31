package db.dao;

import db.dto.Person;

import java.util.ArrayList;

public interface PersonDAO {
    public ArrayList<Person> GetAll();
    public boolean createPerson(Person Person);
    public Person readPerson(int id);
    public boolean updatePerson(Person Person);
    public boolean deletePerson(int id);
}
