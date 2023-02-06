package ru.tshadrin.teta.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "courses", schema = "courses", catalog = "courses")
public class CoursesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id")
    private Long courseId;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "coursesEntity", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<LessonsEntity> lessons;

    @ManyToMany
    private Set<PersonsEntity> persons;

    public CoursesEntity() {
    }

    public CoursesEntity(String author, String title, List<LessonsEntity> lessons, Set<PersonsEntity> persons) {
        this.author = author;
        this.title = title;
        this.lessons = lessons;
        this.persons = persons;
    }

    public void addLessonToCourse(LessonsEntity lesson) {
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
        lessons.add(lesson);
    }

    public void addPersonToCourse(PersonsEntity person) {
        if (persons == null) {
            persons = new HashSet<>();
        }
        persons.add(person);
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<LessonsEntity> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonsEntity> lessons) {
        this.lessons = lessons;
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
        CoursesEntity that = (CoursesEntity) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(author, that.author) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, author, title);
    }
}
