package com.example.seminarskawp.manlib.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {

    public PasswordsDoNotMatchException(){
        super(String.format("Внесените лозинки не се исти!"));
    }
}
