package com.example.seminarskawp.manlib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookAuthorNotFoundException extends RuntimeException{

    public BookAuthorNotFoundException(Long id){
        super(String.format("Автор на книга со id: %d не беше пронајден.", id));
    }

    public BookAuthorNotFoundException(String name){
        super(String.format("Автор на книга со име: %s не беше пронајден.", name));
    }
}
