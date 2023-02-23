package ru.tshadrin.teta.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "persons", schema = "courses", catalog = "courses")
public class PersonsEntity implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id")
    private long personId;
    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "persons")
    private Set<CoursesEntity> courses;

    @ManyToMany
    private Set<RolesEntity> roles;

    String token;

    public PersonsEntity() {
    }

    public PersonsEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addRoleToPerson(RolesEntity rolesEntity) {
        if (roles == null) {
            roles = new HashSet<>();
        }
        roles.add(rolesEntity);
    }

    public void addCourseToPerson(CoursesEntity coursesEntity) {
        if (courses == null) {
            courses = new HashSet<>();
        }
        courses.add(coursesEntity);
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<CoursesEntity> getCourses() {
        return courses;
    }

    public void setCourses(Set<CoursesEntity> courses) {
        this.courses = courses;
    }

    public Set<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEntity> roles) {
        this.roles = roles;
    }

    public void addRole(RolesEntity rolesEntity) {
        this.roles.add(rolesEntity);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(rolesEntity -> {
                    return new SimpleGrantedAuthority(rolesEntity.getName());
                })
                .collect(Collectors.toList());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsEntity that = (PersonsEntity) o;
        return personId == that.personId && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, username);
    }
}
