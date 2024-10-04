package com.Student.Demo.controller;

import com.Student.Demo.aspect.Enum.MessageType;
import com.Student.Demo.entity.ResponseMessageVO;
import com.Student.Demo.entity.ResponseVO;
import com.Student.Demo.entity.Student;
import com.Student.Demo.serviceimpl.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ResponseVO<Student>> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        ResponseMessageVO message = new ResponseMessageVO("Student created successfully", MessageType.INFO);
        ResponseVO<Student> response = new ResponseVO<>(message, createdStudent);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ResponseVO<List<Student>>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        ResponseMessageVO message = new ResponseMessageVO("Students retrieved successfully", MessageType.INFO);
        ResponseVO<List<Student>> response = new ResponseVO<>(message, students);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ResponseVO<Student>> getStudentById(@PathVariable UUID studentId) {
        Student student = studentService.getStudentById(studentId).orElse(null);
        ResponseMessageVO message = new ResponseMessageVO("Student retrieved successfully", MessageType.INFO);
        ResponseVO<Student> response = new ResponseVO<>(message, student);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<ResponseVO<Student>> updateStudent(@PathVariable UUID studentId, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(studentId, studentDetails);
        ResponseMessageVO message = new ResponseMessageVO("Student updated successfully", MessageType.INFO);
        ResponseVO<Student> response = new ResponseVO<>(message, updatedStudent);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ResponseVO<Void>> deleteStudent(@PathVariable UUID studentId) {
        studentService.deleteStudent(studentId);
        ResponseMessageVO message = new ResponseMessageVO("Student deleted successfully", MessageType.INFO);
        ResponseVO<Void> response = new ResponseVO<>(message, null);
        return ResponseEntity.ok(response);
    }
}



/*

import com.Student.Demo.entity.Student;
import com.Student.Demo.serviceimpl.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student) {
        log.info("Received request to create student with name: {}", student.getName());

        Student createdStudent = studentService.createStudent(student);

        if (createdStudent == null) {
            log.error("Student creation failed. Returning bad request");
            return ResponseEntity.badRequest().build();
        }

        log.info("Student created successfully with ID: {}", createdStudent.getStudentId());
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID studentId) {
        log.info("Received request to get student by ID: {}", studentId);

        Optional<Student> student = studentService.getStudentById(studentId);

        if (student.isEmpty()) {
            log.info("No student found with ID: {}", studentId);
            return ResponseEntity.notFound().build();
        }

        log.info("Returning student with ID: {}", studentId);
        return ResponseEntity.ok(student.get());
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("Received request to get all students");

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            log.info("No students found");
            return ResponseEntity.noContent().build();
        }

        log.info("Returning {} students", students.size());
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable UUID studentId,
            @Validated @RequestBody Student studentDetails) {
        log.info("Received request to update student with ID: {}", studentId);

        Student updatedStudent = studentService.updateStudent(studentId, studentDetails);

        if (updatedStudent == null) {
            log.info("Student update failed. No student found with ID: {}", studentId);
            return ResponseEntity.notFound().build();
        }

        log.info("Student updated successfully with ID: {}", studentId);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID studentId) {
        log.info("Received request to delete student with ID: {}", studentId);

        studentService.deleteStudent(studentId);

        log.info("Student deleted successfully with ID: {}", studentId);
        return ResponseEntity.noContent().build();
    }
}

 */