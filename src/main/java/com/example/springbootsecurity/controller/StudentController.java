package com.example.springbootsecurity.controller;

import java.util.Arrays;
import java.util.List;

import com.example.springbootsecurity.models.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
        new Student(1L, "Yuniski Duran"),
        new Student(2L, "Anna Smith"),
        new Student(3L, "Franz Pups")
    );
    
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id) {
        return STUDENTS.stream()
            .filter((s) -> id.equals(s.getId()))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't exist"));
    }
}
