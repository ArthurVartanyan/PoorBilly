package com.poor.billy.model.operation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Abstract class Operation is parent class for two other classes: Spending and Income.
 *
 * @author King Arthuro Vartanyan / 30.06.2021
 */
@Getter
@Setter
@Entity
@Table(name= "operation", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Income or spending transaction sum
     */
    @Column(name = "sum")
    protected BigDecimal sum;

    /**
     * Income or spending transaction date
     */
    @Column(name = "transaction_date")
    protected Date transactionDate;
}