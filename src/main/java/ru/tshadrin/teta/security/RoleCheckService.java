package ru.tshadrin.teta.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleCheckService {
    public boolean canCallGetCourses(Authentication authentication) {
        Set<String> collect = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        return collect.contains(Role.ROLE_ADMIN.name()) || collect.contains(Role.ROLE_EDITOR.name());
    }
}
