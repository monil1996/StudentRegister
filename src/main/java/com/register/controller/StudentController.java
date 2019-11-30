package com.register.controller;

import com.register.models.Student;
import com.register.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    Student student;

    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody Student student){
        student = studentService.saveStudent(student);

        if(student != null){
            return new ResponseEntity(student, HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getStudents")
    public ResponseEntity getAllStudents(){
        return new ResponseEntity(studentService.getStudents(),HttpStatus.OK);
    }

    @GetMapping("/getStudentByStudentId/{id}")
    public ResponseEntity getStudentByStudentId(@PathVariable int id){
        student = studentService.getStudentByStudentId(id);

        if(student != null){
            return new ResponseEntity(student,HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
