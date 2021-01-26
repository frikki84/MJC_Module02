package com.epam.esm.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.sql.SQLException;
import java.time.LocalDateTime;


@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NoSuchResourceException.class)
    public ResponseEntity<ExceptionDetails> handleNoSuchResourceException(NoSuchResourceException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorCode = status.value()+ exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), status.value(), exception.getMessage(), errorCode);

        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<ExceptionDetails> handleInvalidDataException(InvalidDataException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String errorCode = status.value() + exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), status.value(), exception.getMessage(), errorCode);
        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler({TagAlreadyExistsException.class, SQLException.class})
    public ResponseEntity<ExceptionDetails> handleTagAlreadyExistsException(InvalidDataException exception) {
        HttpStatus status = HttpStatus.CONFLICT;
        String errorCode = status.value() + exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), status.value(), exception.getMessage(), errorCode);
        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler({GeneralException.class})
    public ResponseEntity<ExceptionDetails> handlerGeneralException(GeneralException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorCode = status.value() + exception.getCode();
        ExceptionDetails data = new ExceptionDetails(LocalDateTime.now(), status.value(), exception.getMessage(), errorCode);
        return new ResponseEntity<>(data, status);
    }


}
