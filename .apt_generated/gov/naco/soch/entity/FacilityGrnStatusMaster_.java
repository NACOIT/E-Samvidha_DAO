package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityGrnStatusMaster.class)
public abstract class FacilityGrnStatusMaster_ {

	public static volatile SingularAttribute<FacilityGrnStatusMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<FacilityGrnStatusMaster, Long> createdBy;
	public static volatile SingularAttribute<FacilityGrnStatusMaster, Boolean> isDelete;
	public static volatile SetAttribute<FacilityGrnStatusMaster, FacilityReceipt> facilityReceipts;
	public static volatile SingularAttribute<FacilityGrnStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<FacilityGrnStatusMaster, Long> modifiedBy;
	public static volatile SingularAttribute<FacilityGrnStatusMaster, Long> id;
	public static volatile SingularAttribute<FacilityGrnStatusMaster, Boolean> isActive;
	public static volatile SingularAttribute<FacilityGrnStatusMaster, String> status;

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

