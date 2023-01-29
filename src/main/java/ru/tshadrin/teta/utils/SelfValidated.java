package ru.tshadrin.teta.utils;

import ru.tshadrin.teta.dto.CourseCreateDTO;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.logging.Logger;

public class SelfValidated {
    public final Validator validator;
    private final Logger logger;

    public SelfValidated() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        logger = Logger.getAnonymousLogger();
    }

    public void validateSelf() {
        Set<ConstraintViolation<SelfValidated>> constraintViolations = validator.validate(this);
        constraintViolations
                .forEach(selfValidatedConstraintViolation -> selfValidatedConstraintViolation
                        .getConstraintDescriptor()
                        .getPayload()
                        .forEach(aClass -> {
                                    if (aClass == CourseCreateDTO.Soft.class) {
                                        logger.info("Soft class validation started");
                                    } else if (aClass == CourseCreateDTO.Hard.class) {
                                        logger.info("Soft class validation started");
                                    } else {
                                        logger.info("Payload not provided");
                                    }
                                }
                        ));
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
