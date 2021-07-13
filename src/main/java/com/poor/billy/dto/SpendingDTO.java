package com.poor.billy.dto;

import com.poor.billy.model.operation.SpendingType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SpendingDTO {

    @NotBlank(message = "This field can not be empty!")
    @Min(value = 1)
    private BigDecimal sum;

    private Date transactionDate;

    @NotBlank(message = "This field can not be empty!")
    private SpendingType type;
}