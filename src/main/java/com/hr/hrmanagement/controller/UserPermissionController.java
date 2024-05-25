package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-permissions")
public class UserPermissionController {

    @Autowired
    private PersonService personService;

    @GetMapping("/users")
    public List<Person> getAllUsers() {
        return personService.getAllPersons();
    }

    @PutMapping("/user/{id}")
    public Person updateUser(@PathVariable int id, @RequestBody Person person) {
        Person existingPerson = personService.getPersonById(id);
        if (existingPerson != null) {
            existingPerson.setAuthority(person.getAuthority());
            personService.updatePerson(existingPerson);
        }
        return existingPerson;
    }
}