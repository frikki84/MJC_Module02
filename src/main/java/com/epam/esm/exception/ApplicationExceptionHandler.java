package com.epam.esm.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


import java.sql.SQLException;
import java.time.LocalDateTime;


@ControllerAdvice
public  class ApplicationExceptionHandler{

    @ExceptionHandler(NoSuchResourceException.class)
     public ResponseEntity<ExceptionDetails> handleNoSuchResourceException(NoSuchResourceException exception, WebRequest request) {
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidDataException.class, Exception.class })
    public ResponseEntity<ExceptionDetails> handleInvalidDataException(InvalidDataException exception, WebRequest request) {
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }


}
