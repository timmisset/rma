package com.misset.rma.mapper;

public class RmaMappingException extends RuntimeException {

    public RmaMappingException(Exception exception) {
        super(exception);
    }
}
