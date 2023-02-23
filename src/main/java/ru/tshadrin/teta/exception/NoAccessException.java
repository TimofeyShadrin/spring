package ru.tshadrin.teta.exception;

public class NoAccessException extends IllegalStateException{
    public NoAccessException(String s) {
        super(s);
    }
}
