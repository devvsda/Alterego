package com.devsda.hack.alterego.exception;

public class AlteregoExternalException extends AlteregoException {

    public AlteregoExternalException(String message) {
        super(message);
    }

    public AlteregoExternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlteregoExternalException(Throwable cause) {
        super(cause);
    }
}
