package com.example.studentregistrationsystem.controller;

import com.example.studentregistrationsystem.model.Student;
import com.example.studentregistrationsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET one student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Create student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student created = studentService.createStudent(student);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // PUT - Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,@RequestBody Student student) {
        return studentService.updateStudent(id, student)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (!studentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllStudents() {
        studentService.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
