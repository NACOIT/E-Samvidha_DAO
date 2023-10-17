package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterRouteOfTransmission.class)
public abstract class MasterRouteOfTransmission_ {

	public static volatile SingularAttribute<MasterRouteOfTransmission, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterRouteOfTransmission, String> code;
	public static volatile SingularAttribute<MasterRouteOfTransmission, Integer> createdBy;
	public static volatile SingularAttribute<MasterRouteOfTransmission, Boolean> isDelete;
	public static volatile SingularAttribute<MasterRouteOfTransmission, String> name;
	public static volatile SingularAttribute<MasterRouteOfTransmission, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterRouteOfTransmission, String> description;
	public static volatile SingularAttribute<MasterRouteOfTransmission, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterRouteOfTransmission, Long> id;
	public static volatile SingularAttribute<MasterRouteOfTransmission, Boolean> isActive;

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

