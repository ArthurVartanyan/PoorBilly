package com.poor.billy.model.operation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Income cash
 */
@Getter
@Setter
@Entity
@Table(name = "income", schema = "public")
public class Income extends Operation {

    /**
     * Income cash's type. For example: gift or salary
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private IncomeType type;
}