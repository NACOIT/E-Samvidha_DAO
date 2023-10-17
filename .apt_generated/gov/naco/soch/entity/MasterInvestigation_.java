package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterInvestigation.class)
public abstract class MasterInvestigation_ {

	public static volatile SingularAttribute<MasterInvestigation, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterInvestigation, String> code;
	public static volatile SingularAttribute<MasterInvestigation, Integer> createdBy;
	public static volatile SingularAttribute<MasterInvestigation, Boolean> isDelete;
	public static volatile SingularAttribute<MasterInvestigation, String> name;
	public static volatile SingularAttribute<MasterInvestigation, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterInvestigation, String> description;
	public static volatile SingularAttribute<MasterInvestigation, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterInvestigation, Long> id;
	public static volatile SingularAttribute<MasterInvestigation, Boolean> isActive;

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

