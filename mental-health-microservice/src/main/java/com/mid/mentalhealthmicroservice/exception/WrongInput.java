package com.mid.mentalhealthmicroservice.exception;

public class WrongInput extends Exception{
    private static final String MESSAGE = "You've put the wrong input";

    public WrongInput() {
        super(MESSAGE);
    }
}
