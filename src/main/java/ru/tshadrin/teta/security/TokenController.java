package ru.tshadrin.teta.security;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tshadrin.teta.domain.PersonsEntity;
import ru.tshadrin.teta.repository.PersonRepository;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/token")
public class TokenController {
    private final PersonRepository personRepository;

    public TokenController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public String generateToken(
            @RequestParam String username,
            @RequestParam String password
    ) {
        PersonsEntity personsEntity =
                personRepository.findByUsernameAndPassword(username, password)
                .stream().findFirst().orElseThrow(() -> new IllegalStateException("No user found"));
        int randomToken = ThreadLocalRandom.current().nextInt();
        String token = "username_" + randomToken;
        return "";
    }
}
