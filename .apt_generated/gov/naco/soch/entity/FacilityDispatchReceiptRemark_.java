package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityDispatchReceiptRemark.class)
public abstract class FacilityDispatchReceiptRemark_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, FacilityDispatchStatusMaster> facilityDispatchStatusMaster;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, FacilityReceipt> facilityReceipt;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, Integer> id;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, FacilityDispatch> facilityDispatch;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, Boolean> isActive;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, String> remarks;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, UserMaster> userMaster1;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, UserMaster> userMaster2;
	public static volatile SingularAttribute<FacilityDispatchReceiptRemark, FacilityReceiptStatusMaster> facilityReceiptStatusMaster;

	public static final String FACILITY_DISPATCH_STATUS_MASTER = "facilityDispatchStatusMaster";
	public static final String FACILITY_RECEIPT = "facilityReceipt";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String FACILITY_DISPATCH = "facilityDispatch";
	public static final String IS_ACTIVE = "isActive";
	public static final String REMARKS = "remarks";
	public static final String USER_MASTER1 = "userMaster1";
	public static final String USER_MASTER2 = "userMaster2";
	public static final String FACILITY_RECEIPT_STATUS_MASTER = "facilityReceiptStatusMaster";

}

