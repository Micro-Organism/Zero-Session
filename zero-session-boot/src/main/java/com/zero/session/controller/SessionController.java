package com.zero.session.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/get/{name}")
    public String getSession(HttpServletRequest request, @PathVariable("name") String name) {
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(name);
        return "sessionId:" + session.getId() + " value:" + value;
    }

    @RequestMapping("/add/{name}/{value}")
    public String addSession(HttpServletRequest request, @PathVariable("name") String name, @PathVariable("value") String value) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
        return "sessionId:" + session.getId() + " name:" + name;
    }

}