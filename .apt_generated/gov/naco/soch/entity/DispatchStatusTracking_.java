package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DispatchStatusTracking.class)
public abstract class DispatchStatusTracking_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DispatchStatusTracking, UserMaster> userMaster;
	public static volatile SingularAttribute<DispatchStatusTracking, DispatchStatusMaster> dispatchStatusMaster;
	public static volatile SingularAttribute<DispatchStatusTracking, Dispatch> dispatch;
	public static volatile SingularAttribute<DispatchStatusTracking, ReceiptStatusMaster> receiptStatusMaster;
	public static volatile SingularAttribute<DispatchStatusTracking, Boolean> isDelete;
	public static volatile SingularAttribute<DispatchStatusTracking, Receipt> receipt;
	public static volatile SingularAttribute<DispatchStatusTracking, Integer> id;
	public static volatile SingularAttribute<DispatchStatusTracking, Boolean> isActive;

	public static final String USER_MASTER = "userMaster";
	public static final String DISPATCH_STATUS_MASTER = "dispatchStatusMaster";
	public static final String DISPATCH = "dispatch";
	public static final String RECEIPT_STATUS_MASTER = "receiptStatusMaster";
	public static final String IS_DELETE = "isDelete";
	public static final String RECEIPT = "receipt";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

