package com.practice.practice.dto.response;

import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;

public class StudentOrErrorResponseDTO {
    private StudentResponseDTO studentResponseDTO;
    private ExceptionReturn ex;

    public StudentOrErrorResponseDTO(StudentResponseDTO studentResponseDTO) {
        this.studentResponseDTO = studentResponseDTO;
    }

    public StudentOrErrorResponseDTO(ExceptionNotFound ex) {
        this.ex = new ExceptionReturn(ex);
    }

    public StudentResponseDTO getStudentResponseDTO() {
        return studentResponseDTO;
    }

    public ExceptionReturn getEx() {
        return ex;
    }
}
