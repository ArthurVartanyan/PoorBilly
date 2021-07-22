package com.poor.billy.dto;

import com.poor.billy.model.operation.IncomeType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class IncomeDTO {

    @NotNull(message = "This field can not be empty!")
    @Min(value = 1)
    private BigDecimal sum;

    private Date transactionDate;

    @NotNull(message = "This field can not be empty!")
    private IncomeType type;
}