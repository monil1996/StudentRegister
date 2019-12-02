package com.register.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Students")
@Data
public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private String id;


}
