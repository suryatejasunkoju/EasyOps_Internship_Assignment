package com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse;

public class UserNotFoundExceptionResponse{

    private Long vendorId;
    private String errorMessage;

    public UserNotFoundExceptionResponse() {
    }

    public UserNotFoundExceptionResponse(Long vendorId, String errorMessage) {
        this.vendorId = vendorId;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "UserNotFoundExceptionResponse{" +
                "vendorId=" + vendorId +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
