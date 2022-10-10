package com.example.springbootapirest.exceptions;

import org.springframework.http.HttpStatus;

public class BlogAppException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    private HttpStatus estate;
    private String message;

    public BlogAppException(HttpStatus estate, String message) {
        super();
        this.estate = estate;
        this.message = message;
    }

    public BlogAppException(HttpStatus estate, String message, String message1) {
        super();
        this.estate = estate;
        this.message = message;
        this.message = message1;
    }

    public HttpStatus getEstate() {
        return estate;
    }

    public void setEstate(HttpStatus estate) {
        this.estate = estate;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
