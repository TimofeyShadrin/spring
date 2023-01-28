package ru.tshadrin.teta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tshadrin.teta.domain.CoursesEntity;
import ru.tshadrin.teta.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursesEntity> findById(@PathVariable Long id) {
        return ResponseEntity.of(courseService.findById(id));
    }
}
