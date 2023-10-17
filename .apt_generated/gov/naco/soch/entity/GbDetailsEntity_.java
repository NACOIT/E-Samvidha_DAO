package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GbDetailsEntity.class)
public abstract class GbDetailsEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<GbDetailsEntity, String> firstname;
	public static volatile SingularAttribute<GbDetailsEntity, Long> facilityId;
	public static volatile SingularAttribute<GbDetailsEntity, String> education;
	public static volatile SingularAttribute<GbDetailsEntity, String> mobileNumber;
	public static volatile SingularAttribute<GbDetailsEntity, Long> roleId;
	public static volatile SingularAttribute<GbDetailsEntity, Boolean> isDelete;
	public static volatile SingularAttribute<GbDetailsEntity, Long> id;
	public static volatile SingularAttribute<GbDetailsEntity, Boolean> isActive;
	public static volatile SingularAttribute<GbDetailsEntity, String> email;

	public static final String FIRSTNAME = "firstname";
	public static final String FACILITY_ID = "facilityId";
	public static final String EDUCATION = "education";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String ROLE_ID = "roleId";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String EMAIL = "email";

}

