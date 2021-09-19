package com.pracSpringPro.Exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ExceptionResponse{

    private ZonedDateTime timeStamp;
    private String message;
    private HttpStatus httpStatus;
    private String Description;

    public ExceptionResponse(ZonedDateTime timeStamp, String message, HttpStatus httpStatus, String description) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.httpStatus = httpStatus;
        Description = description;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDescription() {
        return Description;
    }
}
