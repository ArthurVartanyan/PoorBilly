package com.poor.billy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldErrorDTO {

    private String field;

    private String message;
}