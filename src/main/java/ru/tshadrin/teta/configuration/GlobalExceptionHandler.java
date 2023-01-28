package ru.tshadrin.teta.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tshadrin.teta.dto.FieldValidationErrorDTO;
import ru.tshadrin.teta.dto.RequestValidationErrorDTO;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RequestValidationErrorDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<FieldValidationErrorDTO> errors = exception.getFieldErrors().stream()
                .map(fieldError -> new FieldValidationErrorDTO(
                        fieldError.getField(), fieldError.getDefaultMessage()
                )).toList();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RequestValidationErrorDTO(errors));
    }
}
