package com.example.EasyOpsAssignment.CustomExceptions;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {
    private Long vendorId;

    public UserNotFoundException(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}
