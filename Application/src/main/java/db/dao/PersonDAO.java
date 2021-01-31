package db.dao;

import db.dto.Person;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonDAO {
    public ArrayList<Person> GetAll() throws SQLException;
    public boolean createPerson(Person person) throws SQLException;
    public Person readPerson(int id) throws SQLException;
    public boolean updatePerson(Person person) throws SQLException;
    public boolean deletePerson(int id) throws SQLException;
}
