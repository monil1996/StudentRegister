package com.register.util;

import lombok.Data;

@Data
public class StudentResponse<T> {

    private String message;
    private T data;

}
