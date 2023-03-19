package newProject.rep;

import newProject.entity.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

public class SecondRealisation implements PersonRep{

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findOne(int id) {
        return null;
    }

    @Override
    public Person updatePerson(int id, Person person) {
        return null;
    }

    @Override
    public void createPerson(Person person) {

    }

    @Override
    public List<Person> searchByObject(Person person) {
        return null;
    }

    @Override
    public void deletePerson(int id) {

    }
}
