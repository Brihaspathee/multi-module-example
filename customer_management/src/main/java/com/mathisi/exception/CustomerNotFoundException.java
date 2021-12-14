package com.mathisi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, December 2021
 * Time: 10:31 PM
 * Project: multi_module
 * Package Name: com.mathisi.exception
 * To change this template use File | Settings | File and Code Template
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(){

    }

    public CustomerNotFoundException(String message){
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
