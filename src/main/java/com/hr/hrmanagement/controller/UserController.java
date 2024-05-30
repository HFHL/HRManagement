package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PersonService personService;

    @GetMapping("/info")
    public Person getUserInfo(HttpSession session) {
        Person user = (Person) session.getAttribute("user");
        return personService.getPersonById(user.getId());
    }

    @PutMapping("/edit")
    public Map<String, Object> updateUserInfo(@RequestBody Person person, HttpSession session) {
        Person currentUser = (Person) session.getAttribute("user");
        Map<String, Object> response = new HashMap<>();
        if (currentUser != null && currentUser.getId() == person.getId()) {
            personService.updatePerson(person);
            response.put("success", true);
        } else {
            response.put("success", false);
            response.put("message", "无权限更新信息");
        }
        return response;
    }
}