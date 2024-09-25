package com.raj.springsecurity6.controller;

import com.raj.springsecurity6.model.Student;
import com.raj.springsecurity6.model.Users;
import com.raj.springsecurity6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    private List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1,"raj", 60),
                    new Student(2, "mehedi", 65)
            )
    );

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.varify(user);
    }

}
