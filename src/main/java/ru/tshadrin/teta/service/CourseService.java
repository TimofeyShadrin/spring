package ru.tshadrin.teta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tshadrin.teta.domain.CoursesEntity;
import ru.tshadrin.teta.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public List<CoursesEntity> findAll() {
        return courseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<CoursesEntity> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public CoursesEntity create(CoursesEntity courses) {
        return courseRepository.save(courses);
    }

    @Transactional(readOnly = true)
    public List<CoursesEntity> findByPrefix(String prefix) {
        return courseRepository.findByTitleContainingIgnoreCase(prefix);
    }

    @Transactional
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
