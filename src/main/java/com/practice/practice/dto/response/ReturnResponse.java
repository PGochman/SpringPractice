package com.practice.practice.dto.response;

import com.practice.practice.exception.ExceptionReturn;

import java.util.List;

public class ReturnResponse {
    private Object data;
    public ReturnResponse(ExceptionReturn ex) {
        this.data = ex;
    }
    public ReturnResponse(CourseResponseDTO data) {
        this.data = data;
    }
    public ReturnResponse(GradeResponseDTO data) {
        this.data = data;
    }
    public ReturnResponse(ProfessorResponseDTO data) {
        this.data = data;
    }
    public ReturnResponse(StringResponse data) {
        this.data = data;
    }
    public ReturnResponse(StudentResponseDTO data) {
        this.data = data;
    }
    public ReturnResponse(List<?> list){
        this.data = list;
    }
    public Object getData() {
        return data;
    }

}
