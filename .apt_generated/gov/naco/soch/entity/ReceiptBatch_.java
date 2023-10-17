package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReceiptBatch.class)
public abstract class ReceiptBatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ReceiptBatch, Long> grn1Quantity;
	public static volatile SingularAttribute<ReceiptBatch, Long> damagedQuantity;
	public static volatile SingularAttribute<ReceiptBatch, Boolean> isDelete;
	public static volatile SingularAttribute<ReceiptBatch, Long> grn2Quantity;
	public static volatile SingularAttribute<ReceiptBatch, Receipt> receipt;
	public static volatile SingularAttribute<ReceiptBatch, Long> id;
	public static volatile SingularAttribute<ReceiptBatch, LocalDate> batchManufactureDate;
	public static volatile SingularAttribute<ReceiptBatch, Boolean> isActive;
	public static volatile SingularAttribute<ReceiptBatch, LocalDate> batchExpiryDate;
	public static volatile SingularAttribute<ReceiptBatch, Long> dispatchedQuantity;
	public static volatile SingularAttribute<ReceiptBatch, String> batchNumber;

	public static final String GRN1_QUANTITY = "grn1Quantity";
	public static final String DAMAGED_QUANTITY = "damagedQuantity";
	public static final String IS_DELETE = "isDelete";
	public static final String GRN2_QUANTITY = "grn2Quantity";
	public static final String RECEIPT = "receipt";
	public static final String ID = "id";
	public static final String BATCH_MANUFACTURE_DATE = "batchManufactureDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String BATCH_EXPIRY_DATE = "batchExpiryDate";
	public static final String DISPATCHED_QUANTITY = "dispatchedQuantity";
	public static final String BATCH_NUMBER = "batchNumber";

}

