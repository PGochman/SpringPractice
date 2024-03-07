package com.practice.practice.dto.response;

import com.practice.practice.exception.ExceptionReturn;

public class ReturnResponse {
    Object response;

    public ReturnResponse(ExceptionReturn ex) {
        this.response = ex;
    }

    public ReturnResponse(CourseResponseDTO response) {
        this.response = response;
    }

    public ReturnResponse(GradeResponseDTO response) {
        this.response = response;
    }

    public ReturnResponse(ProfessorResponseDTO response) {
        this.response = response;
    }

    public ReturnResponse(StringResponse response) {
        this.response = response;
    }

    public ReturnResponse(StudentResponseDTO response) {
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }
}
