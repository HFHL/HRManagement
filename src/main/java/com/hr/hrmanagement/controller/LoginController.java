package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Person;
import com.hr.hrmanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Map<String, Object> login(@RequestBody Map<String, String> credentials, HttpSession session) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Person person = personService.getPersonByName(username);
        Map<String, Object> response = new HashMap<>();
        if (person != null && person.getPasswd().equals(password)) {
            session.setAttribute("user", person);
            response.put("success", true);
            if ("admin".equals(person.getAuthority())) {
                response.put("redirectUrl", "/admin-home.html");
            } else {
                response.put("redirectUrl", "/user-home.html");
            }
        } else {
            response.put("success", false);
            response.put("message", "用户名或密码错误");
        }
        return response;
    }

    @GetMapping("/logout")
    public Map<String, Object> logout(HttpSession session) {
        session.invalidate();
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return response;
    }
}