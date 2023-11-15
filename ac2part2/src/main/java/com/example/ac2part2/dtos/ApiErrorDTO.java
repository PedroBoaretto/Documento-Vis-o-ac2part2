package com.example.ac2part2.dtos;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiErrorDTO {
    private List<String> errors;

    public ApiErrorDTO(String errorMessage){
        errors = Arrays.asList(errorMessage);
    }

    public ApiErrorDTO(List<String> errorMessage){
        errors = errorMessage;
    }
}
