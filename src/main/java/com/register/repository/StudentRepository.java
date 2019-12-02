package com.register.repository;

import com.register.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByStudentId(String id);
    List<Student> findAll();
    Student save(Student student);
    void delete(Student student);
}
