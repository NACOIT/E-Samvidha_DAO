package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DispatchReceiptRemark.class)
public abstract class DispatchReceiptRemark_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DispatchReceiptRemark, DispatchStatusMaster> dispatchStatusMaster;
	public static volatile SingularAttribute<DispatchReceiptRemark, Dispatch> dispatch;
	public static volatile SingularAttribute<DispatchReceiptRemark, ReceiptStatusMaster> receiptStatusMaster;
	public static volatile SingularAttribute<DispatchReceiptRemark, Boolean> isDelete;
	public static volatile SingularAttribute<DispatchReceiptRemark, Receipt> receipt;
	public static volatile SingularAttribute<DispatchReceiptRemark, Integer> id;
	public static volatile SingularAttribute<DispatchReceiptRemark, Boolean> isActive;
	public static volatile SingularAttribute<DispatchReceiptRemark, String> remarks;
	public static volatile SingularAttribute<DispatchReceiptRemark, UserMaster> userMaster1;
	public static volatile SingularAttribute<DispatchReceiptRemark, UserMaster> userMaster2;

	public static final String DISPATCH_STATUS_MASTER = "dispatchStatusMaster";
	public static final String DISPATCH = "dispatch";
	public static final String RECEIPT_STATUS_MASTER = "receiptStatusMaster";
	public static final String IS_DELETE = "isDelete";
	public static final String RECEIPT = "receipt";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String REMARKS = "remarks";
	public static final String USER_MASTER1 = "userMaster1";
	public static final String USER_MASTER2 = "userMaster2";

}

