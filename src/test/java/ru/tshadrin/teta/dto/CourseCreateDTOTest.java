package ru.tshadrin.teta.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

class CourseCreateDTOTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldThrowException() {
        assertThrows(
                ConstraintViolationException.class,
                () -> new CourseCreateDTO(1L, "Маша", "Курс по вышиванию")
        );
    }
}