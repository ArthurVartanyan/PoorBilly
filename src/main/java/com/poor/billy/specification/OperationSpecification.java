package com.poor.billy.specification;

import com.poor.billy.model.operation.Income;
import com.poor.billy.model.operation.Income_;
import com.poor.billy.model.operation.Spending;
import com.poor.billy.model.operation.Spending_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class OperationSpecification {

    public static Specification<Spending> betweenSpendingDate(Long userId, Date fromDate, Date toDate) {
        Specification<Spending> spendingSpecification = ((root, query, criteriaBuilder)
                -> criteriaBuilder.between(root.get(Spending_.TRANSACTION_DATE), fromDate, toDate));
        return spendingSpecification
                .and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Spending_.USER), userId)))
                .and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Spending_.DELETED), false));
    }

    public static Specification<Income> betweenIncomeDate(Long userId, Date fromDate, Date toDate) {
        Specification<Income> incomeSpecification = ((root, query, criteriaBuilder)
                -> criteriaBuilder.between(root.get(Income_.TRANSACTION_DATE), fromDate, toDate));
        return incomeSpecification
                .and(((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Spending_.USER), userId)))
                .and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Spending_.DELETED), false));
    }
}