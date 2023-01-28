package ru.tshadrin.teta.dto;

import java.util.List;

public class RequestValidationErrorDTO {
    private List<FieldValidationErrorDTO> errors;

    public RequestValidationErrorDTO(List<FieldValidationErrorDTO> errorDTOList) {
        this.errors = errorDTOList;
    }

    public List<FieldValidationErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldValidationErrorDTO> errors) {
        this.errors = errors;
    }
}
