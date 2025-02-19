package dev.prithwish.petcare_monolithic_rest_api.rest.advice;

import dev.prithwish.petcare_monolithic_rest_api.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    private Map<String, Object> buildErrorResponse(HttpStatus status, Object error, String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", Instant.now());
        map.put("status", status.value());
        map.put("error", error);
        map.put("path", path);
        return map;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                               HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(buildErrorResponse(status, ex.getMessage(), request.getRequestURI()), status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                                     HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(buildErrorResponse(status, errors, request.getRequestURI()), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(buildErrorResponse(status, ex.getMessage(), request.getRequestURI()), status);
    }
}
