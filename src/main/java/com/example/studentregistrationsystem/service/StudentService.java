package com.example.studentregistrationsystem.service;

import com.example.studentregistrationsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public List<Student> getAllStudents(){
        return new ArrayList<>(students);
    }

    public Student createStudent(Student student){
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    public Optional<Student> getStudentById(Long id){
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public Optional<Student> updateStudent(Long id , Student updatedStudent){
        return getStudentById(id).map( existing -> {
            existing.setName(updatedStudent.getName());
            existing.setGender(updatedStudent.getGender());
            existing.setAge(updatedStudent.getAge());
            existing.setEmail(updatedStudent.getEmail());
            return existing;
        });
    }

    public boolean existsById(Long id){
        return getStudentById(id).isPresent();
    }

    public boolean deleteStudent(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    public void deleteAll() {
        students.clear();
        nextId = 1L;
    }
}
