package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityTypeDivisionMapping.class)
public abstract class FacilityTypeDivisionMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityTypeDivisionMapping, Division> division;
	public static volatile SingularAttribute<FacilityTypeDivisionMapping, FacilityType> facilityType;
	public static volatile SingularAttribute<FacilityTypeDivisionMapping, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityTypeDivisionMapping, Long> id;
	public static volatile SingularAttribute<FacilityTypeDivisionMapping, Boolean> isActive;

	public static final String DIVISION = "division";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

