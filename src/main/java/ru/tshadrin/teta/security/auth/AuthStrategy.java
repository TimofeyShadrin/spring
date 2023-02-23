package ru.tshadrin.teta.security.auth;

import javax.servlet.http.HttpServletRequest;

public interface AuthStrategy {
    void checkRole(HttpServletRequest request);
    void setNext(AuthStrategy next);
}
