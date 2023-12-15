package com.example.SpringBootTask.ExceptionHandling;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
