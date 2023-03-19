package newProject.controller;

import newProject.entity.Person;
import newProject.rep.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class MVCController {

    @Autowired
    PersonRep personRep;
//
//    // localhost:8080/p
//    @RequestMapping("/p")
//    public String printStr(){
//        System.out.println("Fofksfewofkeo");
//
//        return "test";
//    }
//
//
//
//    //localhost:8080/pp/query
//    @RequestMapping("/pp/{query}")
//    public String newPrint(@PathVariable String query){
//        System.out.println(query);
//
//        return "test";
//    }
//
//    @RequestMapping("/allpers")
//    public ModelAndView getAllPersons(){
//        List<Person> people = personRep.findAll();
//
//        System.out.println(people);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("people", people);
//
//        modelAndView.setViewName("hello");
//
//        return modelAndView;
//    }
//

// /all persons

    /**
     * {}
     *
     *
     * @return
     */


    @RequestMapping(value ="/persons", method = RequestMethod.GET)
    public ResponseEntity getPersons(){
        List<Person> people = personRep.findAll();

        ResponseEntity<Person> entity = new ResponseEntity(people, HttpStatus.OK);

        return entity;
        // "http://localhost:8080/persons - people"
    }

    // "http://localhost:8080/persons - people"
    // "http://localhost:8080/persons/1 - this person"
    @GetMapping("/persons/{id}")
    public ResponseEntity getOnePerson(@PathVariable Integer id){
        Person person = personRep.findOne(id);

        ResponseEntity<Person> entity = new ResponseEntity(person, HttpStatus.OK);

        return entity;
        // "http://localhost:8080/persons - people"
    }

    // contain in request body json object
    @PostMapping("/persons")
    public ResponseEntity createPerson(@RequestBody Person person){
        personRep.createPerson(person);

        return new ResponseEntity(person, HttpStatus.OK);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id){
        Person person = personRep.findOne(id);

        personRep.deletePerson(id);

        return new ResponseEntity(person, HttpStatus.OK);
        // "http://localhost:8080/persons - people"
    }

    /**
     * {id:1, name:Name}
     *
     * @param person
     * @return
     */
    @PutMapping("/persons")
    public ResponseEntity updatePerson(@RequestBody Person person){
        Person person1 = personRep.updatePerson(person.getId(), person);

        return new ResponseEntity(person1, HttpStatus.OK);
    }







    // /person?id=1&name=Roman

    // /onepers/id=1&name=Roman

    @RequestMapping("/onepers")
    public ModelAndView showOnePerson(@ModelAttribute Person person){
        //System.out.println(person);

        personRep.createPerson(person);


        return new ModelAndView();
    }
//
//
//    /**
//     * .../addpers?name=Roman
//     *
//     * @param person
//     * @return
//     */
//    @RequestMapping("/addpers")
//    public ModelAndView addPerson(@ModelAttribute Person person){
//        System.out.println(person);
//
//        personRep.createPerson(person);
//
//        return new ModelAndView();
//    }
//
//    /**
//     * .../addpers?name=Roman&id=1&num=2
//     *
//     * @param person
//     * @return
//     */
//    @RequestMapping("/updatepers")
//    public ModelAndView updatePerson(@ModelAttribute Person person, @RequestParam int num){
//        System.out.println(person);
//        System.out.println(num);
//
//        personRep.updatePerson(num, person);
//
////        personRep.createPerson(person);
//
//        return new ModelAndView();
//    }
//
//    @RequestMapping(value = "/seebody", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ModelAndView ololo(@RequestBody Person person){
//        System.out.println(person);
//
//
////        personRep.createPerson(person);
//
//        return new ModelAndView();
//    }






}
