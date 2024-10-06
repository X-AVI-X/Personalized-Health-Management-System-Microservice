package com.mid.mentalhealthmicroservice.exception;

public class UserNotFound extends Exception{
    private static final String MESSAGE = "No user exists with this id";

    public UserNotFound() {
        super(MESSAGE);
    }

    public UserNotFound(String message) {
        super(message);
    }
}
