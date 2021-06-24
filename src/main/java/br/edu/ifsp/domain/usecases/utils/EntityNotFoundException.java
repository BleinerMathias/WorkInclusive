package br.edu.ifsp.domain.usecases.utils;

// When not found a data or specific type
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
