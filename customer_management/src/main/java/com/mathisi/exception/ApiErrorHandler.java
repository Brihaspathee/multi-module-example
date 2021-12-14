package com.mathisi.exception;

import com.mathisi.web.model.ApiException;
import com.mathisi.web.model.ApiExceptionList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 13, December 2021
 * Time: 10:54 PM
 * Project: multi_module
 * Package Name: com.mathisi.exception
 * To change this template use File | Settings | File and Code Template
 */
@ControllerAdvice
@Slf4j
public class ApiErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiExceptionList> handleConstraintViolations(ConstraintViolationException exception){
        log.info("Inside the exception handler");
        List<ApiException> errors = new ArrayList<>(exception.getConstraintViolations().size());
        exception.getConstraintViolations().forEach(constraintViolation -> {
            ApiException apiException = ApiException.builder()
                    .exceptionCode(constraintViolation.getPropertyPath().toString())
                    .exceptionMessage(constraintViolation.getMessage())
                    .build();
            errors.add(apiException);
        });
        ApiExceptionList exceptionList = ApiExceptionList.builder().exceptions(errors).build();
        return ResponseEntity.badRequest().body(exceptionList);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiExceptionList> handleBindViolations(BindException exception){
        log.info("Inside the exception handler...");
        List<ApiException> errors = new ArrayList<>(exception.getAllErrors().size());
        exception.getAllErrors().forEach(error -> {
            ApiException apiException = ApiException.builder()
                    .exceptionCode(error.getCode())
                    .exceptionMessage(error.getDefaultMessage())
                    .build();
            errors.add(apiException);
        });
        ApiExceptionList exceptionList = ApiExceptionList.builder().exceptions(errors).build();
        return ResponseEntity.badRequest().body(exceptionList);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiExceptionList> handleCustomerNotFoundException(CustomerNotFoundException exception){
        log.info("Inside the exception handler for customer not found");
        List<ApiException> errors = new ArrayList<>();
        ApiException apiException = ApiException.builder()
                .exceptionCode("100001")
                .exceptionMessage(exception.getMessage())
                .build();
        errors.add(apiException);
        ApiExceptionList exceptionList = ApiExceptionList.builder().exceptions(errors).build();
        return new ResponseEntity<>(exceptionList, HttpStatus.NOT_FOUND);
    }
}
