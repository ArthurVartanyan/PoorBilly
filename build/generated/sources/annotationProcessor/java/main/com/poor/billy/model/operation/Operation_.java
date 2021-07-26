package com.poor.billy.model.operation;

import com.poor.billy.model.user.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Operation.class)
public abstract class Operation_ {

	public static volatile SingularAttribute<Operation, Boolean> deleted;
	public static volatile SingularAttribute<Operation, BigDecimal> sum;
	public static volatile SingularAttribute<Operation, Long> id;
	public static volatile SingularAttribute<Operation, Date> transactionDate;
	public static volatile SingularAttribute<Operation, User> user;

	public static final String DELETED = "deleted";
	public static final String SUM = "sum";
	public static final String ID = "id";
	public static final String TRANSACTION_DATE = "transactionDate";
	public static final String USER = "user";

}

