package com.hr.hrmanagement.service;

import com.hr.hrmanagement.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> searchPersons(String query);
    Person getPersonById(int id);
    Person savePerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int id);
    Person getPersonByName(String name);

    List<Person> getAllPersons();
}