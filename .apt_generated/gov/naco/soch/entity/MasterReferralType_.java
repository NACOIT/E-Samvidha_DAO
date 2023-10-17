package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterReferralType.class)
public abstract class MasterReferralType_ {

	public static volatile SingularAttribute<MasterReferralType, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterReferralType, String> code;
	public static volatile SingularAttribute<MasterReferralType, Integer> createdBy;
	public static volatile SingularAttribute<MasterReferralType, Boolean> isDelete;
	public static volatile SingularAttribute<MasterReferralType, String> name;
	public static volatile SingularAttribute<MasterReferralType, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterReferralType, String> description;
	public static volatile SingularAttribute<MasterReferralType, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterReferralType, Long> id;
	public static volatile SingularAttribute<MasterReferralType, Boolean> isActive;

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

