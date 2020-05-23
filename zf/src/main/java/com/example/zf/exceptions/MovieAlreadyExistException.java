package com.example.zf.exceptions;

public class MovieAlreadyExistException extends RuntimeException {

    public MovieAlreadyExistException(String title) {
        super("Movie"+title+" already exist");
    }
}
