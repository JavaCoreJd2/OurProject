package newProject;

import newProject.controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext("newProject");

        Controller controller = context.getBean("controller", Controller.class);

        controller.printPersons();

    }
}
