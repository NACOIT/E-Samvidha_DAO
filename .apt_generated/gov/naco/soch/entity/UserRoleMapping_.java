package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserRoleMapping.class)
public abstract class UserRoleMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<UserRoleMapping, UserMaster> userMaster;
	public static volatile SingularAttribute<UserRoleMapping, Role> role;
	public static volatile SingularAttribute<UserRoleMapping, Boolean> isDelete;
	public static volatile SingularAttribute<UserRoleMapping, Long> id;
	public static volatile SingularAttribute<UserRoleMapping, Boolean> isActive;

	public static final String USER_MASTER = "userMaster";
	public static final String ROLE = "role";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

