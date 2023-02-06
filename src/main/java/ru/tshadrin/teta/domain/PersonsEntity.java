package ru.tshadrin.teta.domain;

import lombok.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "persons", schema = "courses", catalog = "courses")
public class PersonsEntity {
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
    private Set<RolesEntity> roles = new HashSet<>();

    public PersonsEntity() {
    }

    public PersonsEntity(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
