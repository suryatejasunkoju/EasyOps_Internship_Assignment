package com.example.EasyOpsAssignment.ExceptionHandler;

import com.example.EasyOpsAssignment.CustomExceptions.UserNotFoundException;
import com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse.DBExceptionResponse;
import com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse.UserNotFoundExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.*;
@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        System.out.println("Inside Invalid Argument Exception");
//        InvalidAttributeException exception=new InvalidAttributeException();

        Map<String, String> errorMap=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public DBExceptionResponse handleSQLExceptions(SQLException ex){
        System.out.println("Inside SQl Exception");
        DBExceptionResponse dbExceptionResponse =new DBExceptionResponse();
        dbExceptionResponse.setMessage(ex.getMessage());
        dbExceptionResponse.setErrorCode(ex.getErrorCode());
        dbExceptionResponse.setSqlstate(ex.getSQLState());
        return dbExceptionResponse;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public UserNotFoundExceptionResponse handleUserNotFoundException(UserNotFoundException exception){
        UserNotFoundExceptionResponse response=new UserNotFoundExceptionResponse();
        response.setErrorMessage(exception.getMessage());
        response.setVendorId(response.getVendorId());
        return response;
    }
}
