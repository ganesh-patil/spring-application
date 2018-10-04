package jbr.springmvc.controller.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntriesRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleEntryNotFound(EntryNotFoundException ex) {

        EntriesErrorResponse error = new EntriesErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStampt(System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<Object> buildResponseEntity(Exception ex) {
        EntriesErrorResponse error = new EntriesErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStampt(System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
