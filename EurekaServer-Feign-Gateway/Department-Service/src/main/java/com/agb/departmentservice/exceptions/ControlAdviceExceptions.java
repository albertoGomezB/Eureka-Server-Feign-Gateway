package com.agb.departmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlAdviceExceptions {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<String> departmentNotFound(DepartmentNotFoundException e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
