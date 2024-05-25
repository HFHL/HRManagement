package com.hr.hrmanagement.service.impl;

import com.hr.hrmanagement.dao.PersonnelChangeDao;
import com.hr.hrmanagement.entity.PersonnelChange;
import com.hr.hrmanagement.service.PersonnelChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonnelChangeServiceImpl implements PersonnelChangeService {

    @Autowired
    private PersonnelChangeDao personnelChangeDao;

    @Override
    public List<PersonnelChange> getAllRecords() {
        return personnelChangeDao.findAll();
    }

    @Override
    public PersonnelChange getRecordById(int id) {
        return personnelChangeDao.findById(id);
    }

    @Override
    public PersonnelChange saveRecord(PersonnelChange personnelChange) {
        personnelChangeDao.save(personnelChange);
        return personnelChange;
    }

    @Override
    public void updateRecord(PersonnelChange personnelChange) {
        personnelChangeDao.update(personnelChange);
    }

    @Override
    public void deleteRecord(int id) {
        personnelChangeDao.deleteById(id);
    }
}