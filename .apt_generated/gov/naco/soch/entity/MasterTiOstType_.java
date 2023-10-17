package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterTiOstType.class)
public abstract class MasterTiOstType_ {

	public static volatile SingularAttribute<MasterTiOstType, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterTiOstType, String> code;
	public static volatile SingularAttribute<MasterTiOstType, Integer> createdBy;
	public static volatile SingularAttribute<MasterTiOstType, Boolean> isDelete;
	public static volatile SingularAttribute<MasterTiOstType, String> name;
	public static volatile SingularAttribute<MasterTiOstType, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterTiOstType, String> description;
	public static volatile SingularAttribute<MasterTiOstType, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterTiOstType, Long> id;
	public static volatile SingularAttribute<MasterTiOstType, Boolean> isActive;

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

