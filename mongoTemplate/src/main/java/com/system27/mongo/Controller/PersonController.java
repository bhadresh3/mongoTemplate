package com.system27.mongo.Controller;

import com.system27.mongo.Model.Person;
import com.system27.mongo.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAll(){
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person){

        return personService.add(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Person updatePerson(@RequestBody Person person){
        return personService.update(person);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@RequestParam("id") String id){
         personService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/salaryGt")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPersonBySalary(@RequestParam("salary") int salary){
        return personService.getBySalary(salary);
    }

}
