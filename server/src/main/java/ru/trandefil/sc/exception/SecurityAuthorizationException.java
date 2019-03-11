package ru.trandefil.sc.exception;

public class SecurityAuthorizationException extends RuntimeException {
    public SecurityAuthorizationException(String message) {
        super(message);
    }
}
