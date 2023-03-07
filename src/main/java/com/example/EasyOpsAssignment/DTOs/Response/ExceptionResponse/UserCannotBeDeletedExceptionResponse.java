package com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse;



public class UserCannotBeDeletedExceptionResponse{
    UserNotFoundExceptionResponse response;

    public UserCannotBeDeletedExceptionResponse(UserNotFoundExceptionResponse response) {
        this.response = response;
    }
}
