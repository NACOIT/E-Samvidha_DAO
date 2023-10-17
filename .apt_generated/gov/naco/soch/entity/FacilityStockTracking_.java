package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockTracking.class)
public abstract class FacilityStockTracking_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityStockTracking, FacilityStockTrackingType> facilityStockTrackingType;
	public static volatile SingularAttribute<FacilityStockTracking, Product> product;
	public static volatile SingularAttribute<FacilityStockTracking, Double> quantity;
	public static volatile SingularAttribute<FacilityStockTracking, Long> referenceNo;
	public static volatile SingularAttribute<FacilityStockTracking, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockTracking, Long> id;
	public static volatile SingularAttribute<FacilityStockTracking, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockTracking, LocalDate> transactionDate;
	public static volatile SingularAttribute<FacilityStockTracking, Facility> facility;
	public static volatile SingularAttribute<FacilityStockTracking, String> batchNumber;

	public static final String FACILITY_STOCK_TRACKING_TYPE = "facilityStockTrackingType";
	public static final String PRODUCT = "product";
	public static final String QUANTITY = "quantity";
	public static final String REFERENCE_NO = "referenceNo";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String TRANSACTION_DATE = "transactionDate";
	public static final String FACILITY = "facility";
	public static final String BATCH_NUMBER = "batchNumber";

}

