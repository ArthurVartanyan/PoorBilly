package com.poor.billy.model.operation;

import com.poor.billy.model.user.User;
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
@Table(name = "operation", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Income or spending transaction sum
     */
    @Column(name = "sum", nullable = false)
    protected BigDecimal sum;

    /**
     * Income or spending transaction date
     */
    @Column(name = "transaction_date", nullable = false)
    protected Date transactionDate;

    /**
     * Is deleted recording or not
     */
    @Column(name = "deleted", nullable = false)
    protected Boolean deleted;

    /**
     * The user who owns the operations
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    protected User user;
}