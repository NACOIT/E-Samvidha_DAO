package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterMonthlyIncome.class)
public abstract class MasterMonthlyIncome_ {

	public static volatile SingularAttribute<MasterMonthlyIncome, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterMonthlyIncome, String> code;
	public static volatile SingularAttribute<MasterMonthlyIncome, Integer> createdBy;
	public static volatile SingularAttribute<MasterMonthlyIncome, Boolean> isDelete;
	public static volatile SingularAttribute<MasterMonthlyIncome, String> name;
	public static volatile SingularAttribute<MasterMonthlyIncome, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterMonthlyIncome, String> description;
	public static volatile SingularAttribute<MasterMonthlyIncome, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterMonthlyIncome, Long> id;
	public static volatile SingularAttribute<MasterMonthlyIncome, Boolean> isActive;

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

