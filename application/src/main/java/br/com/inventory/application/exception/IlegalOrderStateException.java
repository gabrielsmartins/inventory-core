package br.com.inventory.application.exception;

public class IlegalOrderStateException extends RuntimeException {

    public IlegalOrderStateException(String message) {
        super(message);
    }
}
