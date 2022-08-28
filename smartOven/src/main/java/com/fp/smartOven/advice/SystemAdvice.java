package com.fp.smartOven.advice;


import com.fp.smartOven.exceptions.CustomExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice

public class SystemAdvice {
    @ExceptionHandler(value = {CustomExceptions.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionDetails handleException(Exception exception){
        return new ExceptionDetails("error: ", exception.getMessage());
    }
}
