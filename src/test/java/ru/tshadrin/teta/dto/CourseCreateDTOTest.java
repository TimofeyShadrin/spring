package ru.tshadrin.teta.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {
            "Олег", "Николай", "Михаил"
    })
    void shouldThrowExceptionIfAuthorIsIncorrect(String author) {
        assertThrows(
                ConstraintViolationException.class,
                () -> new CourseCreateDTO(1L, author, "Курс по вышиванию")
        );
    }

    @Test
    void shouldSuccessfully() {
        assertDoesNotThrow(
                () -> new CourseCreateDTO(1L, "Вася", "Java для начинающих")
        );
    }
}