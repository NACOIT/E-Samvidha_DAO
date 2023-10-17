package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReceiptStatusMaster.class)
public abstract class ReceiptStatusMaster_ {

	public static volatile SetAttribute<ReceiptStatusMaster, Receipt> receipts;
	public static volatile SingularAttribute<ReceiptStatusMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ReceiptStatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<ReceiptStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ReceiptStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ReceiptStatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ReceiptStatusMaster, Long> id;
	public static volatile SingularAttribute<ReceiptStatusMaster, Boolean> isActive;
	public static volatile SingularAttribute<ReceiptStatusMaster, String> status;

	public static final String RECEIPTS = "receipts";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

