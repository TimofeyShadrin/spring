package ru.tshadrin.teta.annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthorAllowedConstraintValidatorTest {

    private AuthorAllowedConstraintValidator validator;
    private AuthorAllowed authorAllowed;

    @BeforeEach
    void setUp() {
        validator = new AuthorAllowedConstraintValidator();
        authorAllowed = mock(AuthorAllowed.class);
        when(authorAllowed.authors())
                .thenReturn(new String[]{"Bob"});
    }

    @Test
    void shouldFailValidation() {
        validator.initialize(authorAllowed);
        assertFalse(validator.isValid("Timothy", mock(ConstraintValidatorContext.class)));
    }

    @Test
    void shouldSuccessfullyValidation() {
        validator.initialize(authorAllowed);
        assertTrue(validator.isValid("Bob", mock(ConstraintValidatorContext.class)));
    }
}