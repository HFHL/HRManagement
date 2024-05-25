package com.hr.hrmanagement.dao;

import com.hr.hrmanagement.entity.PersonnelChange;
import java.util.List;

public interface PersonnelChangeDao {
    List<PersonnelChange> findAll();
    PersonnelChange findById(int id);
    int save(PersonnelChange personnelChange);
    int update(PersonnelChange personnelChange);
    int deleteById(int id);
}