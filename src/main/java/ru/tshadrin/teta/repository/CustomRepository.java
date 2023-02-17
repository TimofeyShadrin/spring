package ru.tshadrin.teta.repository;

import ru.tshadrin.teta.domain.CoursesEntity;

import java.util.List;

public interface CustomRepository {
    List<CoursesEntity> findCourseWithTitle(String title);
}
