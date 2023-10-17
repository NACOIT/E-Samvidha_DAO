package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityDispatchStatusMaster.class)
public abstract class FacilityDispatchStatusMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityDispatchStatusMaster, Boolean> isDelete;
	public static volatile SetAttribute<FacilityDispatchStatusMaster, FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;
	public static volatile SingularAttribute<FacilityDispatchStatusMaster, Long> id;
	public static volatile SingularAttribute<FacilityDispatchStatusMaster, Boolean> isActive;
	public static volatile SetAttribute<FacilityDispatchStatusMaster, FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;
	public static volatile SetAttribute<FacilityDispatchStatusMaster, FacilityDispatch> facilityDispatches;
	public static volatile SingularAttribute<FacilityDispatchStatusMaster, String> status;

	public static final String IS_DELETE = "isDelete";
	public static final String FACILITY_DISPATCH_RECEIPT_REMARKS = "facilityDispatchReceiptRemarks";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_DISPATCH_STATUS_TRACKINGS = "facilityDispatchStatusTrackings";
	public static final String FACILITY_DISPATCHES = "facilityDispatches";
	public static final String STATUS = "status";

}

