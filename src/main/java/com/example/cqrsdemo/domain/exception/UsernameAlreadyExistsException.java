package com.example.cqrsdemo.domain.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("Username allaqachon mavjud: " + username);
    }
}
