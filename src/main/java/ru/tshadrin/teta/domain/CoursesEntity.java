package ru.tshadrin.teta.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courses", schema = "products", catalog = "products")
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

    public CoursesEntity() {
    }

    public CoursesEntity(Long courseId, String author, String title) {
        this.courseId = courseId;
        this.author = author;
        this.title = title;
    }

    public long getCourseId() {
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
