package ru.tshadrin.teta.utils;

import lombok.extern.slf4j.Slf4j;
import ru.tshadrin.teta.dto.CourseCreateDTO;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Slf4j
public class SelfValidated {
    public final Validator validator;

    public SelfValidated() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public void validateSelf() {
        Set<ConstraintViolation<SelfValidated>> constraintViolations = validator.validate(this);
        constraintViolations
                .forEach(selfValidatedConstraintViolation -> selfValidatedConstraintViolation
                        .getConstraintDescriptor()
                        .getPayload()
                        .forEach(aClass -> {
                                    if (aClass == CourseCreateDTO.Soft.class) {
                                        log.info("Soft class validation started");
                                    } else if (aClass == CourseCreateDTO.Hard.class) {
                                        log.info("Soft class validation started");
                                    } else {
                                        log.info("Payload not provided");
                                    }
                                }
                        ));
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
