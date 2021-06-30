package com.poor.billy.model.operation;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Abstract class Operation is parent class for two other classes: Spending and Income.
 *
 * @author King Arthuro Vartanyan / 30.06.2021
 */
@Getter
@Setter
public abstract class Operation {

    /**
     * Income or spending transaction sum
     */
    protected BigDecimal sum;

    /**
     * Income or spending transaction date
     */
    protected Date transactionDate;
}