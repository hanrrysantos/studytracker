package com.hanrry.studytracker.exception.handler;



import com.hanrry.studytracker.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<StandardError> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, HttpServletRequest request){
        String error = "EmailAlreadyExistsException";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
        String error = "ResourceNotFoundException";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleAllExceptions(Exception ex, HttpServletRequest request){
        String error = "Exception";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String error = "Validation error";
        String message = "Validation failed for one or more fields";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        List<FieldMessage> errors = new ArrayList<>();

        for (FieldError f : ex.getBindingResult().getFieldErrors()) {
            errors.add(new FieldMessage(f.getField(), f.getDefaultMessage()));
        }

        ValidationError err = new ValidationError(Instant.now(), status.value(), error, message, request.getRequestURI(), errors);

        return ResponseEntity.status(status).body(err);
    }
}
