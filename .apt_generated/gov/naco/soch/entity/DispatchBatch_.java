package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DispatchBatch.class)
public abstract class DispatchBatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DispatchBatch, Dispatch> dispatch;
	public static volatile SingularAttribute<DispatchBatch, Boolean> isDelete;
	public static volatile SingularAttribute<DispatchBatch, Long> quantityNumber;
	public static volatile SingularAttribute<DispatchBatch, Long> id;
	public static volatile SingularAttribute<DispatchBatch, Boolean> isActive;
	public static volatile SingularAttribute<DispatchBatch, LocalDate> batchManufactureDate;
	public static volatile SingularAttribute<DispatchBatch, LocalDate> batchExpiryDate;
	public static volatile SingularAttribute<DispatchBatch, String> batchNumber;

	public static final String DISPATCH = "dispatch";
	public static final String IS_DELETE = "isDelete";
	public static final String QUANTITY_NUMBER = "quantityNumber";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String BATCH_MANUFACTURE_DATE = "batchManufactureDate";
	public static final String BATCH_EXPIRY_DATE = "batchExpiryDate";
	public static final String BATCH_NUMBER = "batchNumber";

}

