package ru.tshadrin.teta.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lessons", schema = "courses", catalog = "courses")
public class LessonsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lesson_id")
    private long lessonId;
    @Basic
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "text")
    private String text;

    @ManyToOne(optional = false)
    private CoursesEntity coursesEntity;

    public LessonsEntity() {
    }

    public LessonsEntity(String title, String text, CoursesEntity coursesEntity) {
        this.title = title;
        this.text = text;
        this.coursesEntity = coursesEntity;
    }

    public CoursesEntity getCoursesEntity() {
        return coursesEntity;
    }

    public void setCoursesEntity(CoursesEntity coursesEntity) {
        this.coursesEntity = coursesEntity;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonsEntity that = (LessonsEntity) o;
        return lessonId == that.lessonId && Objects.equals(title, that.title) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, title, text);
    }
}
