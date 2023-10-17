package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityDispatchProductBatch.class)
public abstract class FacilityDispatchProductBatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityDispatchProductBatch, Long> quantityDispatched;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, FacilityDispatchProduct> facilityDispatchProduct;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, Long> id;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, LocalDate> batchManufactureDate;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, Boolean> isActive;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, LocalDate> batchExpiryDate;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, Long> boxesNo;
	public static volatile SingularAttribute<FacilityDispatchProductBatch, String> batchNumber;

	public static final String QUANTITY_DISPATCHED = "quantityDispatched";
	public static final String FACILITY_DISPATCH_PRODUCT = "facilityDispatchProduct";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String BATCH_MANUFACTURE_DATE = "batchManufactureDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String BATCH_EXPIRY_DATE = "batchExpiryDate";
	public static final String BOXES_NO = "boxesNo";
	public static final String BATCH_NUMBER = "batchNumber";

}

