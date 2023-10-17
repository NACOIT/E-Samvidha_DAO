package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dispensation.class)
public abstract class Dispensation_ {

	public static volatile SingularAttribute<Dispensation, Timestamp> modifiedTime;
	public static volatile SingularAttribute<Dispensation, String> adherence;
	public static volatile SingularAttribute<Dispensation, Boolean> isDelete;
	public static volatile SingularAttribute<Dispensation, String> dispensedTo;
	public static volatile SingularAttribute<Dispensation, Integer> remainingPills;
	public static volatile SingularAttribute<Dispensation, Boolean> isActive;
	public static volatile SingularAttribute<Dispensation, String> facProdStockTransId;
	public static volatile SingularAttribute<Dispensation, Integer> dispensedQty;
	public static volatile SingularAttribute<Dispensation, Beneficiary> beneficiary;
	public static volatile SingularAttribute<Dispensation, String> createdBy;
	public static volatile SingularAttribute<Dispensation, String> productDispense;
	public static volatile SingularAttribute<Dispensation, Timestamp> createdTime;
	public static volatile SingularAttribute<Dispensation, LocalDate> dispenseDate;
	public static volatile SingularAttribute<Dispensation, LocalDate> visitDate;
	public static volatile SingularAttribute<Dispensation, String> modifiedBy;
	public static volatile SingularAttribute<Dispensation, Long> id;
	public static volatile SingularAttribute<Dispensation, Facility> facility;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String ADHERENCE = "adherence";
	public static final String IS_DELETE = "isDelete";
	public static final String DISPENSED_TO = "dispensedTo";
	public static final String REMAINING_PILLS = "remainingPills";
	public static final String IS_ACTIVE = "isActive";
	public static final String FAC_PROD_STOCK_TRANS_ID = "facProdStockTransId";
	public static final String DISPENSED_QTY = "dispensedQty";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String PRODUCT_DISPENSE = "productDispense";
	public static final String CREATED_TIME = "createdTime";
	public static final String DISPENSE_DATE = "dispenseDate";
	public static final String VISIT_DATE = "visitDate";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String FACILITY = "facility";

}

