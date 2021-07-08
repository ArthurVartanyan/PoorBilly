package com.poor.billy.model.operation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "spending", schema = "public")
public class Spending extends Operation {

    /**
     * Spending cash's type. For example: transport pay
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SpendingType type;
}