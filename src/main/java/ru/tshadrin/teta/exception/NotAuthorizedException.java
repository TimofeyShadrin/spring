package ru.tshadrin.teta.exception;

public class NotAuthorizedException extends IllegalStateException{
    public NotAuthorizedException(String s) {
        super(s);
    }
}
