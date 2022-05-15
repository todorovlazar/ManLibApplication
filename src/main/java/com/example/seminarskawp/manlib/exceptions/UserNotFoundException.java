package com.example.seminarskawp.manlib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super(String.format("Корисник со id: %d не е пронајден.", id));
    }

    public UserNotFoundException(String username){
        super(String.format("Корисник со кориснично име: %s не е пронајден.", username));
    }

}
