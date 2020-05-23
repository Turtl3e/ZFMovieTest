package com.example.zf.exceptions;

public class ActorNotFoundException extends RuntimeException  {

    public ActorNotFoundException(long id) {
        super("Could not find movie with id:" +id);
    }
}
