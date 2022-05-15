package com.example.seminarskawp.manlib.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException{

    public InvalidUsernameOrPasswordException(){
        super(String.format("Не валидно корисничко име и лозинка!"));
    }
}
