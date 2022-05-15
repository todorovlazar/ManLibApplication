package com.example.seminarskawp.manlib.exceptions;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String email){
        super(String.format("Корисник со емаил - %s, веќе постои!", email));
    }
}
