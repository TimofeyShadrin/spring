package ru.tshadrin.teta.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserAuthService userAuthService;

    public SecurityConfiguration(PasswordEncoder passwordEncoder, UserAuthService userAuthService) {
        this.passwordEncoder = passwordEncoder;
        this.userAuthService = userAuthService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("student")
                .password(passwordEncoder.encode("123"))
                .roles("STUDENT")
                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN");
        auth.userDetailsService(userAuthService);
    }
}
