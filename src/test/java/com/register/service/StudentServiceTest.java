package com.register.service;

import com.register.models.Student;
import com.register.repository.StudentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepositoryImpl studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveStudent() {
        when(studentRepository.saveStudent(any(Student.class))).thenReturn(new Student());
        studentService.saveStudent(new Student());
    }

    @Test
    void testGetStudents() {
        when(studentRepository.getAllStudents()).thenReturn(new ArrayList<Student>());
        studentService.getStudents();
    }

    @Test
    void testGetStudentByStudentId() {
        when(studentRepository.getStudentByStudentId(any(String.class))).thenReturn(new Student());
        studentService.getStudentByStudentId("1");
    }

    @Test
    void testDeleteStudentByStudentId() {
        doNothing().when(studentRepository).deleteStudentByStudentId(any(Student.class));
        studentService.deleteStudentByStudentId(new Student());
    }

    @Test
    void testUpdateStudent() {
        when(studentRepository.updateStudent(any(Student.class))).thenReturn(new Student());
        studentService.updateStudent(new Student());
    }
}