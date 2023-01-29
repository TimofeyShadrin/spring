package ru.tshadrin.teta.utils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class SelfValidated {
    public final Validator validator;

    public SelfValidated() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public void validateSelf() {
        Set<ConstraintViolation<SelfValidated>> constraintViolations = validator.validate(this);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
