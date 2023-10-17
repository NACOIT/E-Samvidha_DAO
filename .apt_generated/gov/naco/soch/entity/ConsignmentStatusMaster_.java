package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConsignmentStatusMaster.class)
public abstract class ConsignmentStatusMaster_ {

	public static volatile SingularAttribute<ConsignmentStatusMaster, Timestamp> modifiedTime;
	public static volatile SetAttribute<ConsignmentStatusMaster, Dispatch> dispatches;
	public static volatile SingularAttribute<ConsignmentStatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<ConsignmentStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<ConsignmentStatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<ConsignmentStatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<ConsignmentStatusMaster, Long> id;
	public static volatile SingularAttribute<ConsignmentStatusMaster, Boolean> isActive;
	public static volatile SingularAttribute<ConsignmentStatusMaster, String> status;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String DISPATCHES = "dispatches";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

