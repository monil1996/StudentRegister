package com.register.service;

import com.register.models.Student;
import com.register.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepositoryImpl studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.saveStudent(student);
    }

    public List<Student> getStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentByStudentId(int id) {
        return studentRepository.getStudentByStudentId(id);
    }
}
