package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityDispatchStatusTracking.class)
public abstract class FacilityDispatchStatusTracking_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityDispatchStatusTracking, FacilityDispatchStatusMaster> facilityDispatchStatusMaster;
	public static volatile SingularAttribute<FacilityDispatchStatusTracking, UserMaster> userMaster;
	public static volatile SingularAttribute<FacilityDispatchStatusTracking, FacilityReceipt> facilityReceipt;
	public static volatile SingularAttribute<FacilityDispatchStatusTracking, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityDispatchStatusTracking, Long> id;
	public static volatile SingularAttribute<FacilityDispatchStatusTracking, FacilityDispatch> facilityDispatch;
	public static volatile SingularAttribute<FacilityDispatchStatusTracking, Boolean> isActive;
	public static volatile SingularAttribute<FacilityDispatchStatusTracking, FacilityReceiptStatusMaster> facilityReceiptStatusMaster;

	public static final String FACILITY_DISPATCH_STATUS_MASTER = "facilityDispatchStatusMaster";
	public static final String USER_MASTER = "userMaster";
	public static final String FACILITY_RECEIPT = "facilityReceipt";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String FACILITY_DISPATCH = "facilityDispatch";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_RECEIPT_STATUS_MASTER = "facilityReceiptStatusMaster";

}

