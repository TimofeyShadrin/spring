package ru.tshadrin.teta.domain;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "persons")
    private Set<CoursesEntity> courses;

    @ManyToMany
    private Set<RolesEntity> roles;

    public PersonsEntity() {
    }

    public PersonsEntity(String username, Set<CoursesEntity> courses) {
        this.username = username;
        this.courses = courses;
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
