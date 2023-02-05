package ru.tshadrin.teta.mapper;

import org.mapstruct.Mapper;
import ru.tshadrin.teta.domain.LessonsEntity;
import ru.tshadrin.teta.dto.lesson.LessonDTO;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonDTO toDto (LessonsEntity lessonsEntity);
    LessonsEntity toEntity (LessonDTO lessonDTO);
}
