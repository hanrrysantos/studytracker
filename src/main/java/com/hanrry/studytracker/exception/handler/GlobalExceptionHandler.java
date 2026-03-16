package com.hanrry.studytracker.exception.handler;



import com.hanrry.studytracker.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
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

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<StandardError> handleBadCredentialsException(BadCredentialsException ex, HttpServletRequest request){
        String error = "BadCredentialsException";
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        String message = "Invalid email or password";
        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<StandardError> handleAuthenticationException(AuthenticationException ex, HttpServletRequest request){
        String error = "AuthenticationException";
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        StandardError err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request){
        String error = "AccessDeniedException";
        HttpStatus status = HttpStatus.FORBIDDEN;
        String message = "You do not have permission to access this resource";
        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<StandardError> handleAccessDeniedException(InvalidTokenException ex, HttpServletRequest request){
        String error = "Invalid Token Exception";
        HttpStatus status = HttpStatus.FORBIDDEN;
        String message = "You do not have permission to access this resource";
        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
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
