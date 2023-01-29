package com.misset.rma.exceptions;

public class RMAMissingFieldException extends RMAValidationException {
    public RMAMissingFieldException(String field) {
        super(String.format("Missing required field %s", field));
    }
}
