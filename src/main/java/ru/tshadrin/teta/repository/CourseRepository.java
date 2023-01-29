package ru.tshadrin.teta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tshadrin.teta.domain.CoursesEntity;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity, Long> {
    List<CoursesEntity> findByTitleContainingIgnoreCase(String title);

}
