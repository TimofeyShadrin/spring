package ru.tshadrin.teta.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tshadrin.teta.repository.PersonRepository;

import java.util.stream.Collectors;

//@Service
public class UserAuthService implements UserDetailsService {
    private final PersonRepository personRepository;

    public UserAuthService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByUsername(username)
                .map(personsEntity -> new User(personsEntity.getUsername(),
                        personsEntity.getPassword(),
                        personsEntity.getRoles().stream()
                                .map(rolesEntity -> new SimpleGrantedAuthority(rolesEntity.getName()))
                                .collect(Collectors.toList())))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
