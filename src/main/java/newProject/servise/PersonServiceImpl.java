package newProject.servise;

import newProject.entity.Person;
import newProject.rep.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{


    @Autowired
    PersonRep personRep;

//    @Autowired
//    public PersonServiceImpl(PersonRep personRep){
//        this.personRep = personRep;
//    }

//
//    @Autowired
//    void setPersonRep(PersonRep personRep){
//        this.personRep = personRep;
//    }


    @Override
    public List<Person> findAll() {
        return personRep.findAll();
    }
}
