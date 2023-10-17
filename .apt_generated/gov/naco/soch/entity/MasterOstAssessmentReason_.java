package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterOstAssessmentReason.class)
public abstract class MasterOstAssessmentReason_ {

	public static volatile SingularAttribute<MasterOstAssessmentReason, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterOstAssessmentReason, Integer> createdBy;
	public static volatile SingularAttribute<MasterOstAssessmentReason, Boolean> isDelete;
	public static volatile SingularAttribute<MasterOstAssessmentReason, String> name;
	public static volatile SingularAttribute<MasterOstAssessmentReason, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterOstAssessmentReason, String> description;
	public static volatile SingularAttribute<MasterOstAssessmentReason, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterOstAssessmentReason, Long> id;
	public static volatile SingularAttribute<MasterOstAssessmentReason, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String CREATED_TIME = "createdTime";
	public static final String DESCRIPTION = "description";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

