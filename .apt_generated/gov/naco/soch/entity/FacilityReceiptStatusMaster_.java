package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityReceiptStatusMaster.class)
public abstract class FacilityReceiptStatusMaster_ {

	public static volatile SingularAttribute<FacilityReceiptStatusMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<FacilityReceiptStatusMaster, Long> createdBy;
	public static volatile SingularAttribute<FacilityReceiptStatusMaster, Boolean> isDelete;
	public static volatile SetAttribute<FacilityReceiptStatusMaster, FacilityReceipt> facilityReceipts;
	public static volatile SetAttribute<FacilityReceiptStatusMaster, FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;
	public static volatile SingularAttribute<FacilityReceiptStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<FacilityReceiptStatusMaster, Long> modifiedBy;
	public static volatile SingularAttribute<FacilityReceiptStatusMaster, Long> id;
	public static volatile SingularAttribute<FacilityReceiptStatusMaster, Boolean> isActive;
	public static volatile SetAttribute<FacilityReceiptStatusMaster, FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;
	public static volatile SingularAttribute<FacilityReceiptStatusMaster, String> status;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String FACILITY_RECEIPTS = "facilityReceipts";
	public static final String FACILITY_DISPATCH_RECEIPT_REMARKS = "facilityDispatchReceiptRemarks";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_DISPATCH_STATUS_TRACKINGS = "facilityDispatchStatusTrackings";
	public static final String STATUS = "status";

}

