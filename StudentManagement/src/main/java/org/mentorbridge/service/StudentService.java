
package org.mentorbridge.service;

import org.mentorbridge.dto.StudentDto;
import org.mentorbridge.entity.StudentEntity;
import org.mentorbridge.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add Student
    public StudentDto addStudent(StudentDto studentDto) {

        StudentEntity student = new StudentEntity();

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setPhone(studentDto.getPhone());
        student.setAge(studentDto.getAge());
        student.setCourse(studentDto.getCourse());
        student.setCity(studentDto.getCity());

        StudentEntity savedStudent = studentRepository.save(student);

        StudentDto response = new StudentDto();

        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setEmail(savedStudent.getEmail());
        response.setPhone(savedStudent.getPhone());
        response.setAge(savedStudent.getAge());
        response.setCourse(savedStudent.getCourse());
        response.setCity(savedStudent.getCity());

        return response;
    }

    // Get All Students
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student By ID
    public Optional<StudentEntity> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    // Delete Student
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
