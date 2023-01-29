package ru.tshadrin.teta.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.tshadrin.teta.domain.CoursesEntity;
import ru.tshadrin.teta.dto.CourseCreateDTO;
import ru.tshadrin.teta.dto.CourseDTO;
import ru.tshadrin.teta.mapper.CourseMapper;
import ru.tshadrin.teta.service.CourseService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/courses")
@Api
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @GetMapping
    @ApiOperation("Получение списка всех курсов")
    public ResponseEntity<List<CourseDTO>> findAll() {
        return ResponseEntity.ok(courseService.findAll()
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Получние данных курса по его ID")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.of(courseService.findById(id)
                .map(courseMapper::toDto));
    }

    @PostMapping("/course")
    @ApiOperation("Создание нового курса")
    public ResponseEntity<CourseDTO> create(@Validated(CourseCreateDTO.AuthorGroup.class) @Valid @RequestBody CourseCreateDTO dto) {
        CoursesEntity coursesEntity = courseService.create(courseMapper.toEntity(dto));
        return ResponseEntity.ok(courseMapper.toDto(coursesEntity));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CourseDTO>> filter(@RequestParam(name = "prefix") String prefix) {
        return ResponseEntity.ok(courseService.findByPrefix(prefix).stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<CourseDTO>> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.ok(courseService.findAll()
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList()));
    }
}
