package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterSyphilisStatus.class)
public abstract class MasterSyphilisStatus_ {

	public static volatile SingularAttribute<MasterSyphilisStatus, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterSyphilisStatus, String> code;
	public static volatile SingularAttribute<MasterSyphilisStatus, Integer> createdBy;
	public static volatile SingularAttribute<MasterSyphilisStatus, Boolean> isDelete;
	public static volatile SingularAttribute<MasterSyphilisStatus, String> name;
	public static volatile SingularAttribute<MasterSyphilisStatus, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterSyphilisStatus, String> description;
	public static volatile SingularAttribute<MasterSyphilisStatus, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterSyphilisStatus, Long> id;
	public static volatile SingularAttribute<MasterSyphilisStatus, Boolean> isActive;

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

