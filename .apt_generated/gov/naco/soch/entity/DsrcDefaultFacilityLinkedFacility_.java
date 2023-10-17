package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DsrcDefaultFacilityLinkedFacility.class)
public abstract class DsrcDefaultFacilityLinkedFacility_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DsrcDefaultFacilityLinkedFacility, Facility> defaultFacility;
	public static volatile SingularAttribute<DsrcDefaultFacilityLinkedFacility, Boolean> isDeleted;
	public static volatile SingularAttribute<DsrcDefaultFacilityLinkedFacility, FacilityType> defaultFacilityType;
	public static volatile SingularAttribute<DsrcDefaultFacilityLinkedFacility, Facility> dsrcFacility;
	public static volatile SingularAttribute<DsrcDefaultFacilityLinkedFacility, String> defaultFacilityName;
	public static volatile SingularAttribute<DsrcDefaultFacilityLinkedFacility, Long> id;
	public static volatile SingularAttribute<DsrcDefaultFacilityLinkedFacility, Boolean> isActive;

	public static final String DEFAULT_FACILITY = "defaultFacility";
	public static final String IS_DELETED = "isDeleted";
	public static final String DEFAULT_FACILITY_TYPE = "defaultFacilityType";
	public static final String DSRC_FACILITY = "dsrcFacility";
	public static final String DEFAULT_FACILITY_NAME = "defaultFacilityName";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

