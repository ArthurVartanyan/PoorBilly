package com.poor.billy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorsDTO {

    private String serverError;

    private List<FieldErrorDTO> validationErrors;
}