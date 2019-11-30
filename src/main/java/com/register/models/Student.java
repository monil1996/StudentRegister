package com.register.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Students")
@Data
public class Student {

    private int studentId;
    private String firstName;
    private String lastName;

}
