package ru.tshadrin.teta.dto.lesson;

import ru.tshadrin.teta.domain.CoursesEntity;

public class LessonDTO {
    private long lessonId;
    private String title;
    private String text;
    private CoursesEntity coursesEntity;

    public LessonDTO() {
    }

    public LessonDTO(long lessonId, String title, String text, CoursesEntity coursesEntity) {
        this.lessonId = lessonId;
        this.title = title;
        this.text = text;
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

    public CoursesEntity getCoursesEntity() {
        return coursesEntity;
    }

    public void setCoursesEntity(CoursesEntity coursesEntity) {
        this.coursesEntity = coursesEntity;
    }
}
