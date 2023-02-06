package ru.tshadrin.teta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tshadrin.teta.domain.PersonsEntity;
import ru.tshadrin.teta.domain.RolesEntity;
import ru.tshadrin.teta.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("person")
    public ResponseEntity<PersonsEntity> addPerson(@RequestParam("username") String username,
                                                   @RequestParam("password") String password,
                                                   @RequestParam("role") String role) {
        PersonsEntity personsEntity = new PersonsEntity(username, password);
        personsEntity = personRepository.save(personsEntity);
        return ResponseEntity.ok(personsEntity);
    }
}
