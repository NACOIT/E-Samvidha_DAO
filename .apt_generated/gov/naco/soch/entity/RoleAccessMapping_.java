package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RoleAccessMapping.class)
public abstract class RoleAccessMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<RoleAccessMapping, Role> role;
	public static volatile SingularAttribute<RoleAccessMapping, Long> id;
	public static volatile SingularAttribute<RoleAccessMapping, AccessMaster> accessMaster;

	public static final String ROLE = "role";
	public static final String ID = "id";
	public static final String ACCESS_MASTER = "accessMaster";

}

