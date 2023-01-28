package ru.tshadrin.teta.mapper;

import org.mapstruct.Mapper;
import ru.tshadrin.teta.domain.CoursesEntity;
import ru.tshadrin.teta.dto.CourseCreateDTO;
import ru.tshadrin.teta.dto.CourseDTO;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDto(CoursesEntity courses);
    CoursesEntity toEntity (CourseCreateDTO courseCreateDTO);
}
