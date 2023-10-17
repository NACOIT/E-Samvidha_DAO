package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityReadOnly.class)
public abstract class FacilityReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityReadOnly, String> code;
	public static volatile SingularAttribute<FacilityReadOnly, AddressReadOnly> address;
	public static volatile SingularAttribute<FacilityReadOnly, Boolean> isExternal;
	public static volatile SingularAttribute<FacilityReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityReadOnly, String> name;
	public static volatile SingularAttribute<FacilityReadOnly, Long> facilityTypeId;
	public static volatile SingularAttribute<FacilityReadOnly, Long> id;
	public static volatile SingularAttribute<FacilityReadOnly, Boolean> isActive;

	public static final String CODE = "code";
	public static final String ADDRESS = "address";
	public static final String IS_EXTERNAL = "isExternal";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String FACILITY_TYPE_ID = "facilityTypeId";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

