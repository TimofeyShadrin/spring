package ru.tshadrin.teta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.tshadrin.teta.repository.PersonRepository;

import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = false)
public class SecurityConfiguration implements UserDetailsService{

    private final PersonRepository personRepository;

    public SecurityConfiguration(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/**").permitAll()
                .and()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .httpBasic()
                .and()
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByUsername(username)
                .map(personsEntity -> new User(personsEntity.getUsername(),
                        passwordEncoder().encode(personsEntity.getPassword()),
                        personsEntity.getRoles().stream()
                                .map(rolesEntity -> new SimpleGrantedAuthority(rolesEntity.getName()))
                                .collect(Collectors.toList())))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
