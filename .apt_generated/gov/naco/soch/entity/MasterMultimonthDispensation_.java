package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterMultimonthDispensation.class)
public abstract class MasterMultimonthDispensation_ {

	public static volatile SingularAttribute<MasterMultimonthDispensation, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterMultimonthDispensation, String> code;
	public static volatile SingularAttribute<MasterMultimonthDispensation, Integer> createdBy;
	public static volatile SingularAttribute<MasterMultimonthDispensation, Boolean> isDelete;
	public static volatile SingularAttribute<MasterMultimonthDispensation, String> name;
	public static volatile SingularAttribute<MasterMultimonthDispensation, String> description;
	public static volatile SingularAttribute<MasterMultimonthDispensation, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterMultimonthDispensation, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterMultimonthDispensation, Long> id;
	public static volatile SingularAttribute<MasterMultimonthDispensation, Boolean> isActive;

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

