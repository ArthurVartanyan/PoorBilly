package com.poor.billy.model.operation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Income cash
 */
@Getter
@Setter
@Entity
@Table(name = "spending", schema = "public")
public class Income extends Operation {

    /**
     * Income cash's type. For example: gift or salary
     */
    @Column(name = "type")
    private IncomeType type;
}