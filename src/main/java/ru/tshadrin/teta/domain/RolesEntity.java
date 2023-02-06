package ru.tshadrin.teta.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "courses", catalog = "courses")
public class RolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id")
    private long roleId;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<PersonsEntity> persons;

    public RolesEntity() {
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PersonsEntity> getPersons() {
        return persons;
    }

    public void setPersons(Set<PersonsEntity> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return roleId == that.roleId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name);
    }
}
