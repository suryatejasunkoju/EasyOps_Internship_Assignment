package com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse;

import java.sql.SQLException;

public class DBExceptionResponse {
    private int errorCode;
    private String sqlstate;
    private String message;

    public DBExceptionResponse() {
    }

    public DBExceptionResponse(Integer errorCode, String sqlstate, String message) {
        this.errorCode = errorCode;
        this.sqlstate = sqlstate;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getSqlstate() {
        return sqlstate;
    }

    public void setSqlstate(String sqlstate) {
        this.sqlstate = sqlstate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
