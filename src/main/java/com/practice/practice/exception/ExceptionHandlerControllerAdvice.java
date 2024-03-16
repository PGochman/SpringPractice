package com.practice.practice.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
/**
 * Clase de controlador de consejos para manejar las excepciones globales en la aplicación.
 * Proporciona métodos para manejar diferentes tipos de excepciones y devolver la respuesta necesaria.
 */
@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
    /**
     * Maneja excepciones de lectura de peticiones con tipos de parámetros erróneos
     * @param exception Excepción lanzada
     * @return Excepción personalizada con información necesaria
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ExceptionWrongType badRequest(Exception exception){
        return new ExceptionWrongType(exception.getMessage());
    }

    /**
     * Maneja excepciones de métodos de argumentos no válidos.
     * @param exception Excepción lanzada
     * @return Excepción personalizada con información necesaria
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ExceptionWrongMethod badMethodRequest(MethodArgumentNotValidException exception){
        return new ExceptionWrongMethod(exception);
    }

    /**
     * Maneja excepciones de relación entre entidades no disponible.
     * @param exception Excepción lanzada
     * @return Excepción personalizada con información necesaria
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ExceptionUnavailableConnection.class})
    @ResponseBody
    public ExceptionReturn badConnectionRequest(MethodArgumentNotValidException exception){
        return new ExceptionReturn(exception);
    }
    /**
     * Maneja excepciones de método de solicitud HTTP no permitido.
     * @param exception Excepción lanzada
     * @param req Información de la petición
     * @return Excepción personalizada con información necesaria
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ExceptionWrongRoute badMethodRequest(HttpServletRequest req, Exception exception){
        return new ExceptionWrongRoute(req.getRequestURI(), exception);
    }
    /**
     * Maneja excepciones de recurso no encontrado en la base de datos.
     * @param exception Excepción lanzada
     * @return Excepción personalizada con información necesaria
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ExceptionNotFound.class})
    @ResponseBody
    public ExceptionReturn notFoundException(Exception exception){
        return new ExceptionReturn(exception);
    }
    /**
     * Maneja excepciones de recurso eliminado o con un problema en el estado de actividad.
     * @param exception Excepción lanzada
     * @return Excepción personalizada con información necesaria
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ExceptionDeletedData.class})
    @ResponseBody
    public ExceptionReturn alreadyDeletedException(Exception exception){
        return new ExceptionReturn(exception);
    }
    /**
     * Maneja excepciones de recurso duplicado.
     * @param exception Excepción lanzada
     * @return Excepción personalizada con información necesaria
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseBody
    public ExceptionReturn alreadyExistsException(Exception exception){
        return new ExceptionReturn(new ExceptionAlreadyExists());
    }
}
