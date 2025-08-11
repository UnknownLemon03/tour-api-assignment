package com.makemytour.backend.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse<T> {
    private T data;
    private String error = null;
    private String message = "";
}
