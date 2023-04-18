package com.example.demo.controller;

import com.example.demo.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PersonExceptionHandler {


    @ExceptionHandler
    public ResponseEntity handlePersonNotFound(PersonNotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("code", HttpStatus.NOT_FOUND.value() + "");
        return new ResponseEntity(map, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("code", HttpStatus.BAD_REQUEST.value() + "");
        return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
    }

}
