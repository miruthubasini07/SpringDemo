package com.example.SpringDemo.rest;

import com.example.SpringDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apis")
public class StudentController {
    List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Chellamuthu", "Palanichamy"));
        students.add(new Student("Sureshkumar", "Ramasamy"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
}
