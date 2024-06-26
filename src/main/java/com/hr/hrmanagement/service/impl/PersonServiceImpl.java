package com.hr.hrmanagement.service.impl;

import com.hr.hrmanagement.dao.PersonDao;
import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> searchPersons(String query) {
        return personDao.search(query);
    }

    @Override
    public Person getPersonById(int id) {
        return personDao.findById(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personDao.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.update(person);
    }

    @Override
    public void deletePerson(int id) {
        personDao.deleteById(id);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.findByName(name);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.findAll();
    }

}