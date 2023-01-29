package ru.tshadrin.teta.utils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class SelfValidated {
    public static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public final void validateSelf() {
        final Set<ConstraintViolation<SelfValidated>> constraintViolations = VALIDATOR.validate(this);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
