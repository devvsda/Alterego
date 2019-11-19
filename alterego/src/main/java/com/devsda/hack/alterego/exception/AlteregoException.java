package com.devsda.hack.alterego.exception;

public class AlteregoException extends RuntimeException {

    public AlteregoException(String message) {
        super(message);
    }

    public AlteregoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlteregoException(Throwable cause) {
        super(cause);
    }
}
