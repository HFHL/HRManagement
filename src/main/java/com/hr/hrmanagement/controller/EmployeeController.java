package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Log;
import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import com.hr.hrmanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private PersonService personService;

    @Autowired
    private LogService logService;

    @GetMapping("/search")
    public List<Person> searchEmployees(@RequestParam("query") String query) {
        return personService.searchPersons(query);
    }

    @GetMapping("/{id}")
    public Person getEmployeeById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public Person addEmployee(@RequestBody Person person) {
        Person savedPerson = personService.savePerson(person);

        Log log = new Log();
        log.setDescription("新增员工: " + person.getName());
        log.setTimestamp(new Timestamp(System.currentTimeMillis()));
        logService.saveLog(log);

        return savedPerson;
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
    public Map<String, Object> deleteEmployee(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            personService.deletePerson(id);
            response.put("success", true);

            Log log = new Log();
            log.setDescription("删除员工ID: " + id);
            log.setTimestamp(new Timestamp(System.currentTimeMillis()));
            logService.saveLog(log);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());

            Log log = new Log();
            log.setDescription("删除员工ID: " + id + " 失败，原因: " + e.getMessage());
            log.setTimestamp(new Timestamp(System.currentTimeMillis()));
            logService.saveLog(log);
        }
        return response;
    }
}