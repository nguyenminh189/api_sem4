package com.example.api_sem4.controller;

import com.example.api_sem4.dto.StudentDTO;
import com.example.api_sem4.entity.Student;
import com.example.api_sem4.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDTO studentDTO) {
        Student saveStudent = studentService.saveStudent(studentDTO);
        return ResponseEntity.ok(saveStudent);
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }



}