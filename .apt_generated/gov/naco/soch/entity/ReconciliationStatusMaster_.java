package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReconciliationStatusMaster.class)
public abstract class ReconciliationStatusMaster_ {

	public static volatile SingularAttribute<ReconciliationStatusMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ReconciliationStatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<ReconciliationStatusMaster, Boolean> isDelete;
	public static volatile SetAttribute<ReconciliationStatusMaster, FacilityReceipt> facilityReceipts;
	public static volatile SingularAttribute<ReconciliationStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ReconciliationStatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ReconciliationStatusMaster, Long> id;
	public static volatile SingularAttribute<ReconciliationStatusMaster, Boolean> isActive;
	public static volatile SingularAttribute<ReconciliationStatusMaster, String> status;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String FACILITY_RECEIPTS = "facilityReceipts";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

