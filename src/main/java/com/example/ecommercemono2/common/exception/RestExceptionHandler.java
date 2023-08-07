package com.example.ecommercemono2.common.exception;

import com.example.ecommercemono2.common.constants.ExceptionTypes;
import com.example.ecommercemono2.common.results.ExceptionResult;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ExceptionResult<>(ExceptionTypes.Exception.Validation, validationErrors);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)//422
    public ExceptionResult<Object> handleValidationException(ValidationException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.Business, exception.getMessage());

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)//409
    public ExceptionResult<Object> handleDataIntegrityViolation(DataIntegrityViolationException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.DataIntegrityViolation, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionResult<Object> handleBusinessException(BusinessException exception) {

        //stacktrace: hata neyin nerede olduğunu gösteriyor galiba :)
        return new ExceptionResult<>(ExceptionTypes.Exception.Business, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResult<Object> handleRuntimeException(RuntimeException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.RunTime, exception.getMessage());
    }
}
