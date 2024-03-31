package com.kumar.propertymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class BusinessExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bx){
        return new ResponseEntity<List<ErrorModel>>(bx.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
