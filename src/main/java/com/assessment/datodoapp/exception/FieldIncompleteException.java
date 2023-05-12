package com.assessment.datodoapp.exception;

public class FieldIncompleteException extends RuntimeException {
    public FieldIncompleteException() {
        super("Title must not be empty.");
    }
}
