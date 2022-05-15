package com.example.seminarskawp.manlib.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LibraryNotFoundException extends RuntimeException{

    public LibraryNotFoundException(Long id){
        super(String.format("Library with id: %d was not found.", id));
    }

    public LibraryNotFoundException(String name){
        super(String.format("Library with name: %s was not found.", name));
    }

}
