package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReceiptBatchStatusMaster.class)
public abstract class ReceiptBatchStatusMaster_ {

	public static volatile SingularAttribute<ReceiptBatchStatusMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ReceiptBatchStatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<ReceiptBatchStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ReceiptBatchStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ReceiptBatchStatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ReceiptBatchStatusMaster, Integer> id;
	public static volatile SingularAttribute<ReceiptBatchStatusMaster, Boolean> isActive;
	public static volatile SetAttribute<ReceiptBatchStatusMaster, FacilityReceiptProductBatch> facilityReceiptProductBatches;
	public static volatile SingularAttribute<ReceiptBatchStatusMaster, String> status;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_RECEIPT_PRODUCT_BATCHES = "facilityReceiptProductBatches";
	public static final String STATUS = "status";

}

