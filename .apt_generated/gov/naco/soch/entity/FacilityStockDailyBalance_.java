package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockDailyBalance.class)
public abstract class FacilityStockDailyBalance_ {

	public static volatile SingularAttribute<FacilityStockDailyBalance, Double> availableQuantity;
	public static volatile SingularAttribute<FacilityStockDailyBalance, LocalDate> modifiedTime;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Product> product;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockDailyBalance, LocalDate> batchManufactureDate;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Double> git;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Double> damagedQuantity;
	public static volatile SingularAttribute<FacilityStockDailyBalance, LocalDate> balanceDate;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Integer> createdBy;
	public static volatile SingularAttribute<FacilityStockDailyBalance, LocalDate> createdTime;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Integer> modifiedBy;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Integer> id;
	public static volatile SingularAttribute<FacilityStockDailyBalance, LocalDate> batchExpiryDate;
	public static volatile SingularAttribute<FacilityStockDailyBalance, Facility> facility;
	public static volatile SingularAttribute<FacilityStockDailyBalance, String> batchNumber;

	public static final String AVAILABLE_QUANTITY = "availableQuantity";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String BATCH_MANUFACTURE_DATE = "batchManufactureDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String GIT = "git";
	public static final String DAMAGED_QUANTITY = "damagedQuantity";
	public static final String BALANCE_DATE = "balanceDate";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String BATCH_EXPIRY_DATE = "batchExpiryDate";
	public static final String FACILITY = "facility";
	public static final String BATCH_NUMBER = "batchNumber";

}

