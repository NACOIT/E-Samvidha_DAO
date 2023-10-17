package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityConsignmentStatusMaster.class)
public abstract class FacilityConsignmentStatusMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityConsignmentStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityConsignmentStatusMaster, Long> id;
	public static volatile SingularAttribute<FacilityConsignmentStatusMaster, Boolean> isActive;
	public static volatile SetAttribute<FacilityConsignmentStatusMaster, FacilityDispatch> facilityDispatches;
	public static volatile SingularAttribute<FacilityConsignmentStatusMaster, String> status;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_DISPATCHES = "facilityDispatches";
	public static final String STATUS = "status";

}

