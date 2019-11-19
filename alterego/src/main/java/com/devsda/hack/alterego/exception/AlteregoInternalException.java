package com.devsda.hack.alterego.exception;

public class AlteregoInternalException extends AlteregoException {

    public AlteregoInternalException(String message) {
        super(message);
    }

    public AlteregoInternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlteregoInternalException(Throwable cause) {
        super(cause);
    }
}
