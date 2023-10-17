package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DesignationFacilityTypeMapping.class)
public abstract class DesignationFacilityTypeMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DesignationFacilityTypeMapping, FacilityType> facilityType;
	public static volatile SingularAttribute<DesignationFacilityTypeMapping, Boolean> isDelete;
	public static volatile SingularAttribute<DesignationFacilityTypeMapping, Long> id;
	public static volatile SingularAttribute<DesignationFacilityTypeMapping, Designation> designation;
	public static volatile SingularAttribute<DesignationFacilityTypeMapping, Boolean> isActive;

	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String DESIGNATION = "designation";
	public static final String IS_ACTIVE = "isActive";

}

