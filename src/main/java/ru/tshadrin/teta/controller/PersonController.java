package ru.tshadrin.teta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tshadrin.teta.domain.PersonsEntity;
import ru.tshadrin.teta.domain.RolesEntity;
import ru.tshadrin.teta.repository.PersonRepository;
import ru.tshadrin.teta.repository.RolesRepository;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonRepository personRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonController(PersonRepository personRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("person")
    public ResponseEntity<PersonsEntity> addPerson(@RequestParam("username") String username,
                                                   @RequestParam("password") String password,
                                                   @RequestParam("role") String role) {
        RolesEntity rolesEntity = new RolesEntity(role);
        PersonsEntity personsEntity = new PersonsEntity(username, password);
        personsEntity.addRoleToPerson(rolesEntity);
        return ResponseEntity.ok(personRepository.save(personsEntity));
    }

    @PostConstruct
    @Transactional
    public void fillDB() {
        RolesEntity rolesEntity = new RolesEntity("ROLE_ADMIN");
        rolesRepository.save(rolesEntity);
        PersonsEntity personsEntity = new PersonsEntity("test", passwordEncoder.encode("test"));
        personsEntity.addRoleToPerson(rolesEntity);
        personRepository.save(personsEntity);
    }
}
