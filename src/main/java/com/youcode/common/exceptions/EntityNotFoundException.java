package com.youcode.common.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public <T> EntityNotFoundException(String entityName, T id) {
        super(entityName + " with ID " + id + " not found");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
