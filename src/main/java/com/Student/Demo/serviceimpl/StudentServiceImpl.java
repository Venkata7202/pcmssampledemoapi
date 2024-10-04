package com.Student.Demo.serviceimpl;

import com.Student.Demo.entity.Student;
import com.Student.Demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        log.info("Creating new student with name: {}", student.getName());
        Student savedStudent = studentRepository.save(student);
        log.info("Student created successfully with ID: {}", savedStudent.getStudentId());
        return savedStudent;
    }

    @Override
    public Optional<Student> getStudentById(UUID studentId) {
        log.info("Fetching student by ID: {}", studentId);
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isPresent()) {
            log.info("Student found with ID: {}", studentId);
        } else {
            log.info("No student found with ID: {}", studentId);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Fetching all students");
        List<Student> students = studentRepository.findAll();
        log.info("Found {} students", students.size());
        return students;
    }

    @Override
    public Student updateStudent(UUID studentId, Student studentDetails) {
        log.info("Updating student with ID: {}", studentId);
        Optional<Student> existingStudentOpt = studentRepository.findById(studentId);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            existingStudent.setName(studentDetails.getName());
            existingStudent.setDateOfBirth(studentDetails.getDateOfBirth());
            existingStudent.setGender(studentDetails.getGender());
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setPhoneNumber(studentDetails.getPhoneNumber());
            existingStudent.setAddressLine1(studentDetails.getAddressLine1());
            existingStudent.setAddressLine2(studentDetails.getAddressLine2());
            existingStudent.setCity(studentDetails.getCity());
            existingStudent.setState(studentDetails.getState());
            existingStudent.setZipCode(studentDetails.getZipCode());
            existingStudent.setCountry(studentDetails.getCountry());
            existingStudent.setAcademicDetails(studentDetails.getAcademicDetails());
            existingStudent.setLinkedinProfile(studentDetails.getLinkedinProfile());
            existingStudent.setGithubProfile(studentDetails.getGithubProfile());
            existingStudent.setPersonalWebsite(studentDetails.getPersonalWebsite());
            existingStudent.setSkills(studentDetails.getSkills());
            existingStudent.setProjects(studentDetails.getProjects());
            existingStudent.setCertifications(studentDetails.getCertifications());
            existingStudent.setLanguages(studentDetails.getLanguages());
            existingStudent.setProfessionalExperience(studentDetails.getProfessionalExperience());
            existingStudent.setInternships(studentDetails.getInternships());
            existingStudent.setAwardsAndHonors(studentDetails.getAwardsAndHonors());
            existingStudent.setInterests(studentDetails.getInterests());
            existingStudent.setStudentReferences(studentDetails.getStudentReferences());
            existingStudent.setAdditionalInformation(studentDetails.getAdditionalInformation());
            existingStudent.setUpdatedAt(studentDetails.getUpdatedAt());

            Student updatedStudent = studentRepository.save(existingStudent);
            log.info("Student updated successfully with ID: {}", studentId);
            return updatedStudent;
        } else {
            log.error("No student found with ID: {}", studentId);
            return null;
        }
    }

    @Override
    public void deleteStudent(UUID studentId) {
        log.info("Deleting student with ID: {}", studentId);
        studentRepository.deleteById(studentId);
        log.info("Student deleted successfully with ID: {}", studentId);
    }
}
