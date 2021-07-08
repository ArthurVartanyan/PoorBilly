package com.poor.billy.dto;

import com.poor.billy.model.operation.IncomeType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class IncomeDTO {

    private BigDecimal sum;

    private Date transactionDate;

    private IncomeType type;
}