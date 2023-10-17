package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterBenificiaryTimeAvailability.class)
public abstract class MasterBenificiaryTimeAvailability_ {

	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, String> code;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, Long> createdBy;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, Boolean> isDelete;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, String> name;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, String> description;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, LocalDateTime> createdTime;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, Long> modifiedBy;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, Long> id;
	public static volatile SingularAttribute<MasterBenificiaryTimeAvailability, Boolean> isActive;

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

