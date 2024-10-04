package com.Student.Demo.serviceimpl;



import com.Student.Demo.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {

    Student createStudent(Student student);

    Optional<Student> getStudentById(UUID studentId);

    List<Student> getAllStudents();

    Student updateStudent(UUID studentId, Student studentDetails);

    void deleteStudent(UUID studentId);

    // Add more custom methods as needed
}
