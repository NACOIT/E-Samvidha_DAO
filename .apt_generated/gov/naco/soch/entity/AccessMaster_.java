package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccessMaster.class)
public abstract class AccessMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile ListAttribute<AccessMaster, RoleAccessMapping> roleAccessMappings;
	public static volatile SingularAttribute<AccessMaster, String> code;
	public static volatile SingularAttribute<AccessMaster, Boolean> isDelete;
	public static volatile SingularAttribute<AccessMaster, Boolean> isPrimary;
	public static volatile SingularAttribute<AccessMaster, String> module;
	public static volatile SingularAttribute<AccessMaster, String> name;
	public static volatile SingularAttribute<AccessMaster, String> description;
	public static volatile SingularAttribute<AccessMaster, Boolean> isActive;

	public static final String ROLE_ACCESS_MAPPINGS = "roleAccessMappings";
	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_PRIMARY = "isPrimary";
	public static final String MODULE = "module";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String IS_ACTIVE = "isActive";

}

