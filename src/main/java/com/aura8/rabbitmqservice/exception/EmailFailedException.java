package com.aura8.rabbitmqservice.exception;

public class EmailFailedException extends RuntimeException {
    public EmailFailedException(String message) {
        super(message);
    }
}
