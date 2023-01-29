package ru.tshadrin.teta.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CourseDTO {
    private Long courseId;
    private String author;
    private String title;

    public CourseDTO() {
    }

    @JsonCreator
    public CourseDTO(Long courseId, String author, String title) {
        this.courseId = courseId;
        this.author = author;
        this.title = title;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
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
}
