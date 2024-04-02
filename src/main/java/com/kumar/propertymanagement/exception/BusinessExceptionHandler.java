package com.kumar.propertymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class BusinessExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException mx){
        List<ErrorModel> errorModelList = new ArrayList<>();
        List<FieldError> fieldErrors = mx.getBindingResult().getFieldErrors();
        for(FieldError fe : fieldErrors){
            ErrorModel errorModel = new ErrorModel(fe.getField(), fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<List<ErrorModel>>(errorModelList,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bx){
        return new ResponseEntity<List<ErrorModel>>(bx.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
