package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterDashboardGender.class)
public abstract class MasterDashboardGender_ {

	public static volatile SingularAttribute<MasterDashboardGender, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterDashboardGender, String> code;
	public static volatile SingularAttribute<MasterDashboardGender, Integer> createdBy;
	public static volatile SingularAttribute<MasterDashboardGender, Boolean> isDelete;
	public static volatile SingularAttribute<MasterDashboardGender, String> name;
	public static volatile SingularAttribute<MasterDashboardGender, String> description;
	public static volatile SingularAttribute<MasterDashboardGender, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterDashboardGender, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterDashboardGender, Long> id;
	public static volatile SingularAttribute<MasterDashboardGender, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CODE = "code";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

