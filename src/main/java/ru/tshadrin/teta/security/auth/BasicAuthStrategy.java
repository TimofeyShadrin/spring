package ru.tshadrin.teta.security.auth;

import org.springframework.stereotype.Service;
import ru.tshadrin.teta.domain.PersonsEntity;
import ru.tshadrin.teta.exception.NoAccessException;
import ru.tshadrin.teta.exception.NotAuthorizedException;
import ru.tshadrin.teta.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Base64;

@Service
public class BasicAuthStrategy implements AuthStrategy {
    private final PersonRepository personRepository;
    private AuthStrategy next;

    public BasicAuthStrategy(PersonRepository personRepository) {
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
        if (!authWithInfo[0].equals("Basic")) {
            next.checkRole(request);
            return;
        }

        String rawString = new String(Base64.getDecoder().decode(authWithInfo[1]));
        String[] split = rawString.split(":");
        if (split.length != 2) {
            throw new NotAuthorizedException("Protocol is not supported: " + Arrays.toString(split));
        }
        String username = split[0];
        String password = split[1];
        PersonsEntity personsEntity = personRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new NoAccessException("No user with username " + username));
        if (personsEntity.getRoles().stream().noneMatch(rolesEntity -> (rolesEntity.getName()).equals("ROLE_ADMIN"))) {
            throw new NoAccessException("No rights");
        }
    }

    @Override
    public void setNext(AuthStrategy next) {
        this.next = next;
    }
}
