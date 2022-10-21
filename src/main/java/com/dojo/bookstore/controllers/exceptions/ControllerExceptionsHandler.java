package com.dojo.bookstore.controllers.exceptions;

import com.dojo.bookstore.services.exceptions.DataIntegrityViolationException;
import com.dojo.bookstore.services.exceptions.DatabaseException;
import com.dojo.bookstore.services.exceptions.ObjectNotFoundException;
import com.dojo.bookstore.services.exceptions.SQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> ObjectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError erro = new StandardError(Instant.now(),status.value(),e.getMessage());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(),status.value(),e.getMessage());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> DatabaseException(DatabaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(),status.value(),e.getMessage());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StandardError> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError(Instant.now(),status.value(),e.getMessage());
        return ResponseEntity.status(status).body(erro);
    }
}
