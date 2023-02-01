package ru.tshadrin.teta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tshadrin.teta.domain.LessonsEntity;

@Repository
public interface LessonRepository extends JpaRepository<LessonsEntity, Long> {
}
