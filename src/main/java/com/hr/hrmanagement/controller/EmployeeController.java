package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private PersonService personService;

    @GetMapping("/search")
    public List<Person> searchEmployees(@RequestParam("query") String query) {
        return personService.searchPersons(query);
    }

    @GetMapping("/{id}")
    public Person getEmployeeById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public Person addEmployee(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public Person updateEmployee(@PathVariable int id, @RequestBody Person person) {
        person.setId(id);
        personService.updatePerson(person);
        return person;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        personService.deletePerson(id);
    }
}