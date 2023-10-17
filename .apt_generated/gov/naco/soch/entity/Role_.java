package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<Role, RoleAccessMapping> roleAccessMappings;
	public static volatile SingularAttribute<Role, FacilityType> facilityType;
	public static volatile SingularAttribute<Role, Boolean> isDelete;
	public static volatile SingularAttribute<Role, Boolean> isPrimary;
	public static volatile SetAttribute<Role, UserRoleMapping> userRoleMappings;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, Long> id;
	public static volatile SingularAttribute<Role, Boolean> isActive;

	public static final String ROLE_ACCESS_MAPPINGS = "roleAccessMappings";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_PRIMARY = "isPrimary";
	public static final String USER_ROLE_MAPPINGS = "userRoleMappings";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

