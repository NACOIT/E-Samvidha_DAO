package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Designation.class)
public abstract class Designation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<Designation, DesignationFacilityTypeMapping> designationFacilityTypeMappings;
	public static volatile SingularAttribute<Designation, Boolean> isDelete;
	public static volatile SingularAttribute<Designation, String> description;
	public static volatile SingularAttribute<Designation, Long> id;
	public static volatile SingularAttribute<Designation, Boolean> isActive;
	public static volatile SingularAttribute<Designation, String> title;

	public static final String DESIGNATION_FACILITY_TYPE_MAPPINGS = "designationFacilityTypeMappings";
	public static final String IS_DELETE = "isDelete";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String TITLE = "title";

}

