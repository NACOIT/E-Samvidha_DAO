package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterTreatmentAbssessSites.class)
public abstract class MasterTreatmentAbssessSites_ {

	public static volatile SingularAttribute<MasterTreatmentAbssessSites, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, String> code;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, Integer> createdBy;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, Boolean> isDelete;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, String> name;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, String> description;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, Long> id;
	public static volatile SingularAttribute<MasterTreatmentAbssessSites, Boolean> isActive;

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

