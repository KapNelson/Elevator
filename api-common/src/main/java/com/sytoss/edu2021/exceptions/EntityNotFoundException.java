package com.sytoss.edu2021.exceptions;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
    @Getter
    private int id;

    public EntityNotFoundException(int id, String message) {
        super(message);
        this.id = id;
    }

    public EntityNotFoundException(String message) {
        super(message);
        id = -1;
    }
}
