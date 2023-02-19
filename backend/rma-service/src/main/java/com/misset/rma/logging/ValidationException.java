package com.misset.rma.logging;

public class ValidationException extends RuntimeException {

    public ValidationException(String id, Exception e) {
        super("Validation exception when trying to save id: " + id, e);
    }

    public ValidationException(String id) {
        super("Validation exception when trying to save id: " + id);
    }
}
