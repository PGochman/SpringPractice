package com.practice.practice.exception;

import com.practice.practice.dto.request.AlumnoRequestDTO;

public class AlumnoRequestException extends Exception{
    public AlumnoRequestException(String message) {
        super(message);
    }
}
