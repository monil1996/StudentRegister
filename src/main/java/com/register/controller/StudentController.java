package com.register.controller;

import com.register.models.Student;
import com.register.service.StudentService;
import com.register.util.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    StudentResponse studentResponse;

    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody Student student) {

        studentResponse = new StudentResponse();
        Student student1 = studentService.saveStudent(student);

        if (student1 != null) {
            studentResponse.setMessage("Successfully Saved Student");
            studentResponse.setData(student1.getStudentId());
            return new ResponseEntity(studentResponse, HttpStatus.CREATED);
        } else {
            studentResponse.setMessage("Error while saving Student");
            return new ResponseEntity(studentResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getStudents")
    public ResponseEntity getAllStudents() {

        studentResponse = new StudentResponse();
        List<Student> students = studentService.getStudents();

        if (students != null) {
            studentResponse.setMessage("Successfully Fetched all Students");
            studentResponse.setData(students);
            return new ResponseEntity(studentResponse, HttpStatus.CREATED);
        } else {
            studentResponse.setMessage("Error while fetching Students");
            return new ResponseEntity(studentResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudentByStudentId/{id}")
    public ResponseEntity getStudentByStudentId(@PathVariable String id) {

        studentResponse = new StudentResponse();
        Student student = studentService.getStudentByStudentId(id);

        if (student != null) {
            studentResponse.setMessage("Successfully Fetched Student");
            studentResponse.setData(student);
            return new ResponseEntity(studentResponse, HttpStatus.CREATED);
        } else {
            studentResponse.setMessage("Error while fetching Student");
            return new ResponseEntity(studentResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudentByStudentId(@PathVariable String id, @RequestBody Student student) {

        studentResponse = new StudentResponse();
        Student student1 = studentService.getStudentByStudentId(id);
        if (student1 != null) {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            studentService.updateStudent(student1);
            studentResponse.setMessage("Successfully Updated Student");
            studentResponse.setData(student.getStudentId());
            return new ResponseEntity(studentResponse, HttpStatus.CREATED);
        } else {
            studentResponse.setMessage("Error while Updating Student");
            return new ResponseEntity(studentResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudentByStudentId(@PathVariable String id) {

        studentResponse = new StudentResponse();
        Student student = studentService.getStudentByStudentId(id);
        if (student != null) {
            studentService.deleteStudentByStudentId(student);
            studentResponse.setMessage("Successfully Deleted Student");
            studentResponse.setData(id);
            return new ResponseEntity(studentResponse, HttpStatus.OK);
        } else {
            studentResponse.setMessage("Error while deleting Student");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
