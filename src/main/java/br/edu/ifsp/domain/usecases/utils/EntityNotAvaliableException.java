package br.edu.ifsp.domain.usecases.utils;

// When not found a data or specific type
public class EntityNotAvaliableException extends RuntimeException {
    public EntityNotAvaliableException(String message) {
        super(message);
    }
}
