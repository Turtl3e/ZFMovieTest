package com.example.zf.controlles.advices;

import com.example.zf.exceptions.ActorAlreadyExistException;
import com.example.zf.exceptions.MovieAlreadyExistException;
import com.example.zf.exceptions.MovieNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MovieNotFoundAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String movieNotFoundHandler(MovieNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(ActorAlreadyExistException.class)
    public ResponseEntity<Object> actorAlreadyExistHandler(ActorAlreadyExistException ex, WebRequest request){
        return handleExceptionInternal(ex,ex.getMessage(),new HttpHeaders(),HttpStatus.CONFLICT,request);
    }

    @ResponseBody
    @ExceptionHandler(MovieAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String movieAlreadyExistHandler(MovieAlreadyExistException ex){
        return ex.getMessage();
    }
}
