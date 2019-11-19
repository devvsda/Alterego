package com.devsda.hack.alterego.exception;

public class ClientInvalidRequestException extends AlteregoExternalException {

    public ClientInvalidRequestException(String message) {
        super(message);
    }

    public ClientInvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientInvalidRequestException(Throwable cause) {
        super(cause);
    }
}
