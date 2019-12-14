package com.github.egnaf.spring_docker_example.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException() {
        super("User exists");
    }

    public UserExistsException(String message) {
        super(message);
    }
}
