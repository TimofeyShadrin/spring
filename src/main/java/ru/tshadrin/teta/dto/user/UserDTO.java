package ru.tshadrin.teta.dto.user;

import ru.tshadrin.teta.domain.CoursesEntity;

import java.util.Set;

public class UserDTO {
    private long personId;
    private String username;
    private Set<CoursesEntity> courses;

    public UserDTO() {
    }

    public UserDTO(long personId, String username, Set<CoursesEntity> courses) {
        this.personId = personId;
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
}
