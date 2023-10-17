package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterArtStayingWith.class)
public abstract class MasterArtStayingWith_ {

	public static volatile SingularAttribute<MasterArtStayingWith, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterArtStayingWith, String> code;
	public static volatile SingularAttribute<MasterArtStayingWith, Integer> createdBy;
	public static volatile SingularAttribute<MasterArtStayingWith, Boolean> isDelete;
	public static volatile SingularAttribute<MasterArtStayingWith, String> name;
	public static volatile SingularAttribute<MasterArtStayingWith, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterArtStayingWith, String> description;
	public static volatile SingularAttribute<MasterArtStayingWith, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterArtStayingWith, Long> id;
	public static volatile SingularAttribute<MasterArtStayingWith, Boolean> isActive;

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

