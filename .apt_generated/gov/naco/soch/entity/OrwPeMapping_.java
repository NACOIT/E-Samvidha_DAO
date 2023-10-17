package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrwPeMapping.class)
public abstract class OrwPeMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<OrwPeMapping, Boolean> isDelete;
	public static volatile SingularAttribute<OrwPeMapping, UserMaster> peUser;
	public static volatile SingularAttribute<OrwPeMapping, Long> id;
	public static volatile SingularAttribute<OrwPeMapping, Boolean> isActive;
	public static volatile SingularAttribute<OrwPeMapping, UserMaster> orwUser;

	public static final String IS_DELETE = "isDelete";
	public static final String PE_USER = "peUser";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String ORW_USER = "orwUser";

}

