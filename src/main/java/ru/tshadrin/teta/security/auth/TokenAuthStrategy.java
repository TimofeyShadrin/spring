package ru.tshadrin.teta.security.auth;

import org.springframework.stereotype.Service;
import ru.tshadrin.teta.domain.PersonsEntity;
import ru.tshadrin.teta.exception.NoAccessException;
import ru.tshadrin.teta.exception.NotAuthorizedException;
import ru.tshadrin.teta.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class TokenAuthStrategy implements AuthStrategy {
    private final PersonRepository personRepository;
    private AuthStrategy next;

    public TokenAuthStrategy(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void checkRole(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            throw new NotAuthorizedException("No credentials passed");
        }
        String[] authWithInfo = authorization.split(":");
        if (authWithInfo.length != 2) {
            next.checkRole(request);
            return;
        }
        if (!authWithInfo[0].equals("Bearer")) {
            next.checkRole(request);
            return;
        }
        String token = authWithInfo[1];
        PersonsEntity personsEntity = personRepository.findAll()
                .stream()
                .filter(entity -> Objects.equals(token, entity.getToken()))
                .findFirst()
                .orElseThrow(() -> new NoAccessException("No access for token"));
        if (personsEntity.getRoles().stream().noneMatch(rolesEntity -> (rolesEntity.getName()).equals("ROLE_ADMIN"))) {
            throw new NoAccessException("No rights");
        }
    }

    @Override
    public void setNext(AuthStrategy next) {
        this.next = next;
    }
}
