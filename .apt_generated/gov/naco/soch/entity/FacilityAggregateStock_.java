package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityAggregateStock.class)
public abstract class FacilityAggregateStock_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityAggregateStock, Double> availableQuantity;
	public static volatile SingularAttribute<FacilityAggregateStock, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<FacilityAggregateStock, Product> product;
	public static volatile SingularAttribute<FacilityAggregateStock, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityAggregateStock, LocalDate> batchManufactureDate;
	public static volatile SingularAttribute<FacilityAggregateStock, Boolean> isActive;
	public static volatile SingularAttribute<FacilityAggregateStock, LocalDate> batchInceptionDate;
	public static volatile SingularAttribute<FacilityAggregateStock, Double> git;
	public static volatile SingularAttribute<FacilityAggregateStock, Double> damagedQuantity;
	public static volatile SingularAttribute<FacilityAggregateStock, LocalDate> batchCompletionDate;
	public static volatile SingularAttribute<FacilityAggregateStock, Long> id;
	public static volatile SingularAttribute<FacilityAggregateStock, LocalDate> batchExpiryDate;
	public static volatile SingularAttribute<FacilityAggregateStock, Facility> facility;
	public static volatile SingularAttribute<FacilityAggregateStock, String> batchNumber;

	public static final String AVAILABLE_QUANTITY = "availableQuantity";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String BATCH_MANUFACTURE_DATE = "batchManufactureDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String BATCH_INCEPTION_DATE = "batchInceptionDate";
	public static final String GIT = "git";
	public static final String DAMAGED_QUANTITY = "damagedQuantity";
	public static final String BATCH_COMPLETION_DATE = "batchCompletionDate";
	public static final String ID = "id";
	public static final String BATCH_EXPIRY_DATE = "batchExpiryDate";
	public static final String FACILITY = "facility";
	public static final String BATCH_NUMBER = "batchNumber";

}

