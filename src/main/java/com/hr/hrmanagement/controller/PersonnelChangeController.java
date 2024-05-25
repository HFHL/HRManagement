package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.PersonnelChange;
import com.hr.hrmanagement.service.PersonnelChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnel-changes")
public class PersonnelChangeController {

    @Autowired
    private PersonnelChangeService personnelChangeService;

    @GetMapping
    public List<PersonnelChange> getAllRecords() {
        return personnelChangeService.getAllRecords();
    }

    @GetMapping("/{id}")
    public PersonnelChange getRecordById(@PathVariable int id) {
        return personnelChangeService.getRecordById(id);
    }

    @PostMapping
    public PersonnelChange addRecord(@RequestBody PersonnelChange personnelChange) {
        return personnelChangeService.saveRecord(personnelChange);
    }

    @PutMapping
    public void updateRecord(@RequestBody PersonnelChange personnelChange) {
        personnelChangeService.updateRecord(personnelChange);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable int id) {
        personnelChangeService.deleteRecord(id);
    }
}