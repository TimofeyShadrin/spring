package ru.tshadrin.teta.dto;

import ru.tshadrin.teta.annotation.AuthorAllowed;
import ru.tshadrin.teta.utils.SelfValidated;

import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CourseCreateDTO extends SelfValidated {
    /**
     * Интерфейсы используются как маркеры для групп
     * Никакую логику реализовывать не нужно
     */
    public interface AuthorGroup { }
    public interface TitleGroup { }

    public interface Soft extends Payload { }
    public interface Hard extends Payload { }
    private Long courseId;
    /**
     * Несколько аннотаций соединяются по лигики И
     */
    @AuthorAllowed(authors = {"Вася", "Петя"}, payload = Soft.class)
    @Pattern(regexp = "^В.*$")
    private String author;
    @NotBlank(message = "Курс не может быть без названия", payload = Hard.class)
    private String title;

    public CourseCreateDTO() {
    }

    public CourseCreateDTO(Long courseId, String author, String title) {
        this.courseId = courseId;
        this.author = author;
        this.title = title;
        validateSelf();
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
