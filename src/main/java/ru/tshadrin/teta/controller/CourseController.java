package ru.tshadrin.teta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        return ResponseEntity.ok(courseService.findAll()
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.of(courseService.findById(id).map(courseMapper::toDto));
    }

    @PostMapping("/course")
    public ResponseEntity<CourseDTO> create (@Valid @RequestBody CourseCreateDTO dto) {
        CoursesEntity coursesEntity = courseService.create(courseMapper.toEntity(dto));
        return ResponseEntity.ok(courseMapper.toDto(coursesEntity));
    }
}
