package com.poor.billy.model.operation;

import lombok.Getter;
import lombok.Setter;

/**
 * Income cash
 */
@Getter
@Setter
public class Income extends Operation {

    /**
     * Income cash's type. For example: gift or salary
     */
    private IncomeType type;
}