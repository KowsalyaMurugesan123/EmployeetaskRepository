package com.example.SpringBootTask.ExceptionHandling;
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
