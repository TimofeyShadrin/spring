package ru.tshadrin.teta.security;

import org.springframework.stereotype.Service;
import ru.tshadrin.teta.exception.NotAuthorizedException;
import ru.tshadrin.teta.security.auth.AuthStrategy;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AuthService {
    private final AuthStrategy authStrategy;
    public AuthService(List<AuthStrategy> authStrategies) {
        for (int i = 1; i < authStrategies.size(); i++) {
            AuthStrategy current = authStrategies.get(i);
            AuthStrategy previous = authStrategies.get(i - 1);
            previous.setNext(current);
        }
        authStrategy = authStrategies.get(0);
        authStrategies.get(authStrategies.size() - 1)
                .setNext(new AuthStrategy() {
                    @Override
                    public void checkRole(HttpServletRequest request) {
                        throw new NotAuthorizedException("Not authorized");
                    }

                    @Override
                    public void setNext(AuthStrategy next) {
                        throw new NotAuthorizedException("Not authorized");
                    }
                });
    }

    public void checkRole(HttpServletRequest request) {
        authStrategy.checkRole(request);
    }
}
