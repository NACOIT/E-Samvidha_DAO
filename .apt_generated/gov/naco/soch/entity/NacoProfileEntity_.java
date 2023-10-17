package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NacoProfileEntity.class)
public abstract class NacoProfileEntity_ {

	public static volatile SingularAttribute<NacoProfileEntity, Timestamp> modifiedTime;
	public static volatile SingularAttribute<NacoProfileEntity, Integer> createdBy;
	public static volatile SingularAttribute<NacoProfileEntity, Boolean> isDelete;
	public static volatile SingularAttribute<NacoProfileEntity, Timestamp> createdTime;
	public static volatile SingularAttribute<NacoProfileEntity, Integer> modifiedBy;
	public static volatile SingularAttribute<NacoProfileEntity, Long> id;
	public static volatile SingularAttribute<NacoProfileEntity, String> type;
	public static volatile SingularAttribute<NacoProfileEntity, Boolean> isActive;
	public static volatile SingularAttribute<NacoProfileEntity, String> value;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String IS_ACTIVE = "isActive";
	public static final String VALUE = "value";

}

