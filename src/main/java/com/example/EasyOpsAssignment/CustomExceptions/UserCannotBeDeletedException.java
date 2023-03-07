package com.example.EasyOpsAssignment.CustomExceptions;

import java.util.NoSuchElementException;

public class UserCannotBeDeletedException extends NoSuchElementException {
    UserNotFoundException userNotFoundException;

    public UserCannotBeDeletedException(UserNotFoundException userNotFoundException) {
        this.userNotFoundException = userNotFoundException;
    }

    @Override
    public String toString() {
        return "UserCannotBeDeletedException{" +
                "userNotFoundException=" + userNotFoundException +
                '}';
    }

    public UserNotFoundException getUserNotFoundException() {
        return userNotFoundException;
    }

    public void setUserNotFoundException(UserNotFoundException userNotFoundException) {
        this.userNotFoundException = userNotFoundException;
    }
}
