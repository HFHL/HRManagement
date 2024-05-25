package com.hr.hrmanagement.service;

import com.hr.hrmanagement.entity.PersonnelChange;
import java.util.List;

public interface PersonnelChangeService {
    List<PersonnelChange> getAllRecords();
    PersonnelChange getRecordById(int id);
    PersonnelChange saveRecord(PersonnelChange personnelChange);
    void updateRecord(PersonnelChange personnelChange);
    void deleteRecord(int id);
}