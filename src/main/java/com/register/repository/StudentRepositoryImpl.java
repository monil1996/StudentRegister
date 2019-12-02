package com.register.repository;

import com.register.models.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentRepositoryImpl {

    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByStudentId(String id) {
        return studentRepository.findByStudentId(id);
    }

    public void deleteStudentByStudentId(Student student) {
        studentRepository.delete(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);

    }
}
