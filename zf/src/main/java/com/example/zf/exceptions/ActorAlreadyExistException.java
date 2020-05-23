package com.example.zf.exceptions;

public class ActorAlreadyExistException extends RuntimeException {

    public ActorAlreadyExistException(String firstName,String secondName) {
        super("Actor"+firstName+" "+secondName+" already exist");
    }

    public ActorAlreadyExistException(String firstName,String secondName, String movieTitile) {
        super("Actor"+firstName+" "+secondName+" already exist in movie " +movieTitile);
    }
}
