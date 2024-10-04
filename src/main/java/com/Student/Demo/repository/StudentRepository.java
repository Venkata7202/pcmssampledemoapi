package com.Student.Demo.repository;

import com.Student.Demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findByName(String name);

    List<Student> findByEmail(String email);

    List<Student> findByCity(String city);

    List<Student> findByState(String state);

    List<Student> findByCountry(String country);

    List<Student> findByAcademicDetailsContaining(String keyword);

    List<Student> findBySkillsContaining(String skill);

    List<Student> findByCertificationsContaining(String certification);

    // Add custom methods as needed, similar to the RecruiterRepository

    default List<Student> findByNameOrEmail(@Param("name") String name, @Param("email") String email) {
        // Custom logic to find students by name or email
        List<Student> studentList = null;
        // Implement your custom logic here
        return studentList;
    }
}
