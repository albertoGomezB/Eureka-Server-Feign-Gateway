package com.agb.departmentservice.exceptions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
