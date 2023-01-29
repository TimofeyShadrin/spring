package ru.tshadrin.teta.exception;

import lombok.Getter;
import lombok.With;

@With
@Getter
public class ErrorResponse {
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
