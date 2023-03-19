package newProject;

import newProject.entity.Person;
import newProject.rep.PersonRep;
import newProject.rep.PersonRepImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext("newProject");

        PersonRep rep = context.getBean("personRepImpl", PersonRep.class);
//
//        Person person = new Person("Kol");
//
//        System.out.println(rep.searchByObject(person));
    }
}
