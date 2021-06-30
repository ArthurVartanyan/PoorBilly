package com.poor.billy.model.operation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spending extends Operation {

    /**
     * Spending cash's type. For example: transport pay
     */
    private SpendingType type;
}