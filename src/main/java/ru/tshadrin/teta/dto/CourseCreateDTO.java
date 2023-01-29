package ru.tshadrin.teta.dto;

import ru.tshadrin.teta.annotation.AuthorAllowed;
import ru.tshadrin.teta.utils.SelfValidated;

import javax.validation.constraints.NotBlank;

public class CourseCreateDTO extends SelfValidated {
    private Long courseId;
    @AuthorAllowed(authors = {"Вася", "Петя"})
    private String author;
    @NotBlank(message = "Курс не может быть без названия")
    private String title;

    public CourseCreateDTO() {
    }

    public CourseCreateDTO(Long courseId, String author, String title) {
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
