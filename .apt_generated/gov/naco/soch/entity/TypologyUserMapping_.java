package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TypologyUserMapping.class)
public abstract class TypologyUserMapping_ {

	public static volatile SingularAttribute<TypologyUserMapping, UserMaster> userMaster;
	public static volatile SingularAttribute<TypologyUserMapping, Timestamp> modifiedTime;
	public static volatile SingularAttribute<TypologyUserMapping, Boolean> isDelete;
	public static volatile SingularAttribute<TypologyUserMapping, Integer> modifiedBy;
	public static volatile SingularAttribute<TypologyUserMapping, Long> id;
	public static volatile SingularAttribute<TypologyUserMapping, Boolean> isActive;
	public static volatile SingularAttribute<TypologyUserMapping, TypologyMaster> typologyMaster;

	public static final String USER_MASTER = "userMaster";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String IS_DELETE = "isDelete";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String TYPOLOGY_MASTER = "typologyMaster";

}

