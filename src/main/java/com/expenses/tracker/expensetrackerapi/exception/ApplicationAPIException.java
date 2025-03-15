package com.expenses.tracker.expensetrackerapi.exception;

import org.springframework.http.HttpStatus;

public class ApplicationAPIException extends  RuntimeException{
    private HttpStatus status;
    private String message;
    public ApplicationAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public ApplicationAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }



    public HttpStatus getStatus() {return status;}
    @Override
    public String getMessage() {return message;}


}
