package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DispatchStatusMaster.class)
public abstract class DispatchStatusMaster_ {

	public static volatile SetAttribute<DispatchStatusMaster, DispatchStatusTracking> dispatchStatusTrackings;
	public static volatile SingularAttribute<DispatchStatusMaster, Timestamp> modifiedTime;
	public static volatile SetAttribute<DispatchStatusMaster, Dispatch> dispatches;
	public static volatile SingularAttribute<DispatchStatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<DispatchStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<DispatchStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<DispatchStatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<DispatchStatusMaster, Integer> id;
	public static volatile SingularAttribute<DispatchStatusMaster, Boolean> isActive;
	public static volatile SetAttribute<DispatchStatusMaster, DispatchReceiptRemark> dispatchReceiptRemarks;
	public static volatile SingularAttribute<DispatchStatusMaster, String> status;

	public static final String DISPATCH_STATUS_TRACKINGS = "dispatchStatusTrackings";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String DISPATCHES = "dispatches";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String DISPATCH_RECEIPT_REMARKS = "dispatchReceiptRemarks";
	public static final String STATUS = "status";

}

