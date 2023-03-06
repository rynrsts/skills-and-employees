package com.example.skillsandemployees.controller;

import com.example.skillsandemployees.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFoundException() {
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }

}
