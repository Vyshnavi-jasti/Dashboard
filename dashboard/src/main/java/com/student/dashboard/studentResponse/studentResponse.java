package com.student.dashboard.studentResponse;

import com.student.dashboard.ResponseStatus.StatusEnum;

import lombok.Data;

@Data
public class studentResponse {

    private StatusEnum status;
    private int code;
    private String message;
    private Object data;
    
}
