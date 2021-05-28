package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("admin/api/v1/students")
public class AdminController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1L, "Yuniski Duran"),
            new Student(2L, "Anna Smith"),
            new Student(3L, "Franz Pups")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return STUDENTS;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        System.out.println("addstudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        System.out.println("deleteStudent");
        System.out.println(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestBody Student student) {
        System.out.println("updateStudent");
        System.out.println(id + " " + student);
    }
}
