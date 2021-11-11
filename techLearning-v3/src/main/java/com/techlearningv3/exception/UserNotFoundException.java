package com.techlearningv3.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
