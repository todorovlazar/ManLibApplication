package com.example.seminarskawp.manlib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Long id){
        super(String.format("Книга со id: %d не е пронајдена.", id));
    }

    public BookNotFoundException(String name){
        super(String.format("Книга со име: %s не е пронајдена.", name));
    }
}
