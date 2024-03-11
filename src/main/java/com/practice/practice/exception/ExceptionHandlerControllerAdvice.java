package com.practice.practice.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ExceptionWrongType badRequest(Exception exception){
        return new ExceptionWrongType(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ExceptionWrongMethod badMethodRequest(MethodArgumentNotValidException exception){
        return new ExceptionWrongMethod(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ExceptionUnavailableConnection.class})
    @ResponseBody
    public ExceptionReturn badConnectionRequest(MethodArgumentNotValidException exception){
        return new ExceptionReturn(exception);
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ExceptionWrongRoute badMethodRequest(HttpServletRequest req, Exception exception){
        return new ExceptionWrongRoute(req.getRequestURI(), exception);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ExceptionNotFound.class})
    @ResponseBody
    public ExceptionReturn notFoundException(Exception exception){
        return new ExceptionReturn(exception);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ExceptionDeletedData.class})
    @ResponseBody
    public ExceptionReturn alreadyDeletedException(Exception exception){
        return new ExceptionReturn(exception);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseBody
    public ExceptionReturn alreadyExistsException(Exception exception){
        return new ExceptionReturn(new ExceptionAlreadyExists());
    }
}
