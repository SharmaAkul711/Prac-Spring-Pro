package com.pracSpringPro.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ZonedDateTime.now(ZoneId.of("Z")), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR ,req.getDescription(false) );

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundExceptions(UserNotFoundException ex, WebRequest req){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ZonedDateTime.now(ZoneId.of("Z")), ex.getMessage(), HttpStatus.NOT_FOUND ,req.getDescription(false) );

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ZonedDateTime.now(ZoneId.of("Z")), "Validation Failed", HttpStatus.NOT_ACCEPTABLE ,ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}
