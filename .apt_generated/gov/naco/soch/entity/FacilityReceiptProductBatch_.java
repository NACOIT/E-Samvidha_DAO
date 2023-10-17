package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityReceiptProductBatch.class)
public abstract class FacilityReceiptProductBatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityReceiptProductBatch, LocalDate> reconciliationDate;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, LocalDate> batchManufactureDate;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, Boolean> isActive;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, Long> dispatchedQuantity;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, Long> git;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, Long> damagedQuantity;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, FacilityReceiptProduct> facilityReceiptProduct;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, Long> id;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, ReceiptBatchStatusMaster> receiptBatchStatusMaster;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, LocalDate> batchExpiryDate;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, Long> quantityReceived;
	public static volatile SingularAttribute<FacilityReceiptProductBatch, String> batchNumber;

	public static final String RECONCILIATION_DATE = "reconciliationDate";
	public static final String IS_DELETE = "isDelete";
	public static final String BATCH_MANUFACTURE_DATE = "batchManufactureDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String DISPATCHED_QUANTITY = "dispatchedQuantity";
	public static final String GIT = "git";
	public static final String DAMAGED_QUANTITY = "damagedQuantity";
	public static final String FACILITY_RECEIPT_PRODUCT = "facilityReceiptProduct";
	public static final String ID = "id";
	public static final String RECEIPT_BATCH_STATUS_MASTER = "receiptBatchStatusMaster";
	public static final String BATCH_EXPIRY_DATE = "batchExpiryDate";
	public static final String QUANTITY_RECEIVED = "quantityReceived";
	public static final String BATCH_NUMBER = "batchNumber";

}

