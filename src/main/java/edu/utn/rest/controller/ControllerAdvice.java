package edu.utn.rest.controller;

import edu.utn.rest.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponseDto handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exc) {
        return new ErrorResponseDto(4, exc.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ErrorResponseDto handleNumberFormatException(NumberFormatException exc) {
        return new ErrorResponseDto(4, exc.getLocalizedMessage());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpClientErrorException.class)
    public ErrorResponseDto handleNumberFormatException(HttpClientErrorException exc) {
        return new ErrorResponseDto(4, exc.getResponseBodyAsString());
    }


}
