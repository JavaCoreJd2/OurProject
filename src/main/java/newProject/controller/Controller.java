package newProject.controller;

import newProject.servise.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    @Autowired
    PersonService personService = null;

    public void printPersons() {
        System.out.println(personService.findAll());
    }
}
