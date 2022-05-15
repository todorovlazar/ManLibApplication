package com.example.seminarskawp.manlib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookRatingNotFoundException extends RuntimeException{

    public BookRatingNotFoundException(Long id){
        super(String.format("Рејтинг на книга со id: %d не е пронајден.", id));
    }
}
