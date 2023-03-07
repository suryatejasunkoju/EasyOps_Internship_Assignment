package com.example.EasyOpsAssignment.DTOs.Response.ExceptionResponse;

import java.util.Map;
import java.util.Set;

public class InvalidAttributeException{
    private String errorAtObject;
    private int errorCount;
    private Set<String> errorTypesSet;
    private Map<String, String> errorMap;

    public InvalidAttributeException() {
        super();
    }

    @Override
    public String toString() {
        return "InvalidAttributeException"+"\n"+
                "{" +
                "\n \t"+" objectName=" + errorAtObject +
                "\n \t"+" errorCount=" + errorCount + ","+
                "\n \t"+" errorList="+errorTypesSet+","+
                "\n \t"+" errorMap="+ errorMap +","+
                "\n"+
                "}"+
                "\n";
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public Map<String, String> errorMap () {
        return errorMap;
    }

    public String getErrorAtObject() {
        return errorAtObject;
    }

    public void setErrorAtObject(String errorAtObject) {
        this.errorAtObject = errorAtObject;
    }

    public Set<String> getErrorTypesSet() {
        return errorTypesSet;
    }

    public void setErrorTypesSet(Set<String> errorTypesSet) {
        this.errorTypesSet = errorTypesSet;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }
}
