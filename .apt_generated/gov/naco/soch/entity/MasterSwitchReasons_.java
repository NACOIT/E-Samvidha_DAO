package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterSwitchReasons.class)
public abstract class MasterSwitchReasons_ {

	public static volatile SingularAttribute<MasterSwitchReasons, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterSwitchReasons, String> code;
	public static volatile SingularAttribute<MasterSwitchReasons, Integer> createdBy;
	public static volatile SingularAttribute<MasterSwitchReasons, Boolean> isDelete;
	public static volatile SingularAttribute<MasterSwitchReasons, String> name;
	public static volatile SingularAttribute<MasterSwitchReasons, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterSwitchReasons, String> description;
	public static volatile SingularAttribute<MasterSwitchReasons, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterSwitchReasons, Long> id;
	public static volatile SingularAttribute<MasterSwitchReasons, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CODE = "code";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String CREATED_TIME = "createdTime";
	public static final String DESCRIPTION = "description";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

