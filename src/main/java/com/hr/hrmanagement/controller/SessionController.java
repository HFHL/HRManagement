package com.hr.hrmanagement.controller;

import com.hr.hrmanagement.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionController {

    @GetMapping("/session")
    public Map<String, Object> getSessionInfo(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        Person user = (Person) session.getAttribute("user");
        if (user != null) {
            response.put("user", user);
        }
        return response;
    }
}