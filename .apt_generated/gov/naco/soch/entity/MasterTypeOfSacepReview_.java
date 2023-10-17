package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterTypeOfSacepReview.class)
public abstract class MasterTypeOfSacepReview_ {

	public static volatile SingularAttribute<MasterTypeOfSacepReview, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, String> code;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, Integer> createdBy;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, Boolean> isDelete;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, String> name;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, String> description;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, Long> id;
	public static volatile SingularAttribute<MasterTypeOfSacepReview, Boolean> isActive;

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

