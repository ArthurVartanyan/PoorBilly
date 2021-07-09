package com.poor.billy.dto;

import com.poor.billy.model.operation.IncomeType;
import com.poor.billy.model.operation.SpendingType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SpendingDTO {

    private BigDecimal sum;

    private Date transactionDate;

    private SpendingType type;
}