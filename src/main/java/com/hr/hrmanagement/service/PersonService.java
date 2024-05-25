package com.hr.hrmanagement.service;

import com.hr.hrmanagement.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(int id);
    Person savePerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int id);
    List<Person> searchPersons(String query); // 添加搜索方法
    Person getPersonByName(String name);

}