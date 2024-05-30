package com.hr.hrmanagement.dao;

import com.hr.hrmanagement.entity.Person;
import java.util.List;

public interface PersonDao {
    List<Person> findAll();
    Person findById(int id);
    Person save(Person person);
    void update(Person person);
    void deleteById(int id);
    List<Person> search(String query); // 添加搜索方法
    Person findByName(String name);

}