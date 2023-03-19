package newProject.rep;

import newProject.entity.Person;

import java.util.List;

public interface PersonRep {
    List<Person> findAll();

    Person findOne(int id);
//
    Person updatePerson(int id, Person person);
//
    void createPerson(Person person);

    List<Person> searchByObject(Person person);

    void deletePerson(int id);

    //Person findPersonById();
}
