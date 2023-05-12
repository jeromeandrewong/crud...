package com.assessment.datodoapp.exception;

public class FieldIncompleteException extends RuntimeException {
    public FieldIncompleteException() {
        super("If creating task, title must not be empty ; If updating task, title, description and completed has to be in the request body.");
    }
}
