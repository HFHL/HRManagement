package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Log;
import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hr.hrmanagement.service.LogService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    private LogService logService;

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
    public Person updateEmployee(@PathVariable int id, @RequestBody Person person) {
        person.setId(id);
        personService.updatePerson(person);

        Log log = new Log();
        log.setDescription("更新员工信息: " + person.getName());
        log.setTimestamp(new Timestamp(System.currentTimeMillis()));
        logService.saveLog(log);

        return person;
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }
}