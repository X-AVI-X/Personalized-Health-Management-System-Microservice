package com.mid.mentalhealthmicroservice.exception;

public class ExerciseNotFound extends Exception {
    private static final String MESSAGE = "No exercise exists in this name";

    public ExerciseNotFound() {
        super(MESSAGE);
    }

    public ExerciseNotFound(String message) {
        super(message);
    }
}