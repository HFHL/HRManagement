package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable int id, @RequestBody Person person) {
        person.setId(id);
        personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }
}