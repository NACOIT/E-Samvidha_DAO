package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilitySetting.class)
public abstract class FacilitySetting_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilitySetting, String> rntcpDefault;
	public static volatile SingularAttribute<FacilitySetting, FacilityType> facilityType;
	public static volatile SingularAttribute<FacilitySetting, Boolean> isDelete;
	public static volatile SingularAttribute<FacilitySetting, String> tiDefault;
	public static volatile SingularAttribute<FacilitySetting, Long> id;
	public static volatile SingularAttribute<FacilitySetting, String> dsrcDefault;
	public static volatile SingularAttribute<FacilitySetting, Boolean> isActive;
	public static volatile SingularAttribute<FacilitySetting, Facility> facility;
	public static volatile SingularAttribute<FacilitySetting, String> ictcDefault;

	public static final String RNTCP_DEFAULT = "rntcpDefault";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String TI_DEFAULT = "tiDefault";
	public static final String ID = "id";
	public static final String DSRC_DEFAULT = "dsrcDefault";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String ICTC_DEFAULT = "ictcDefault";

}

