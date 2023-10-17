package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IndentProductSchedule.class)
public abstract class IndentProductSchedule_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IndentProductSchedule, Double> unitPrice;
	public static volatile SingularAttribute<IndentProductSchedule, Long> quantity;
	public static volatile SingularAttribute<IndentProductSchedule, Boolean> isDelete;
	public static volatile SetAttribute<IndentProductSchedule, IndentProductScheduleSac> indentProductScheduleSacs;
	public static volatile SingularAttribute<IndentProductSchedule, Long> id;
	public static volatile SingularAttribute<IndentProductSchedule, String> scheduleNumber;
	public static volatile SingularAttribute<IndentProductSchedule, IndentProduct> indentProduct;
	public static volatile SingularAttribute<IndentProductSchedule, Boolean> isActive;

	public static final String UNIT_PRICE = "unitPrice";
	public static final String QUANTITY = "quantity";
	public static final String IS_DELETE = "isDelete";
	public static final String INDENT_PRODUCT_SCHEDULE_SACS = "indentProductScheduleSacs";
	public static final String ID = "id";
	public static final String SCHEDULE_NUMBER = "scheduleNumber";
	public static final String INDENT_PRODUCT = "indentProduct";
	public static final String IS_ACTIVE = "isActive";

}

