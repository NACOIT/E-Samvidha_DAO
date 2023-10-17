package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterBloodBankOwnedBy.class)
public abstract class MasterBloodBankOwnedBy_ {

	public static volatile SingularAttribute<MasterBloodBankOwnedBy, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, String> code;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, Integer> createdBy;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, Boolean> isDelete;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, String> name;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, String> description;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, Long> id;
	public static volatile SingularAttribute<MasterBloodBankOwnedBy, Boolean> isActive;
	public static volatile SetAttribute<MasterBloodBankOwnedBy, Facility> facilities;

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
	public static final String FACILITIES = "facilities";

}

