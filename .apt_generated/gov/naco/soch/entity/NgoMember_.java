package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NgoMember.class)
public abstract class NgoMember_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NgoMember, String> firstname;
	public static volatile SingularAttribute<NgoMember, String> mobileNumber;
	public static volatile SingularAttribute<NgoMember, Long> roleId;
	public static volatile SingularAttribute<NgoMember, Boolean> isDelete;
	public static volatile SingularAttribute<NgoMember, byte[]> photo;
	public static volatile SingularAttribute<NgoMember, Long> id;
	public static volatile SingularAttribute<NgoMember, String> landlineNumber;
	public static volatile SingularAttribute<NgoMember, byte[]> idproof;
	public static volatile SingularAttribute<NgoMember, Boolean> isActive;
	public static volatile SingularAttribute<NgoMember, Facility> facility;
	public static volatile SingularAttribute<NgoMember, String> email;
	public static volatile SingularAttribute<NgoMember, String> lastname;

	public static final String FIRSTNAME = "firstname";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String ROLE_ID = "roleId";
	public static final String IS_DELETE = "isDelete";
	public static final String PHOTO = "photo";
	public static final String ID = "id";
	public static final String LANDLINE_NUMBER = "landlineNumber";
	public static final String IDPROOF = "idproof";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String EMAIL = "email";
	public static final String LASTNAME = "lastname";

}

