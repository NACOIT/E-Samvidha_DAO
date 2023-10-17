package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterModeOfDispensation.class)
public abstract class MasterModeOfDispensation_ {

	public static volatile SingularAttribute<MasterModeOfDispensation, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterModeOfDispensation, String> code;
	public static volatile SingularAttribute<MasterModeOfDispensation, Integer> createdBy;
	public static volatile SingularAttribute<MasterModeOfDispensation, Boolean> isDelete;
	public static volatile SingularAttribute<MasterModeOfDispensation, String> name;
	public static volatile SingularAttribute<MasterModeOfDispensation, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterModeOfDispensation, String> description;
	public static volatile SingularAttribute<MasterModeOfDispensation, Integer> modifiedBy;
	public static volatile SetAttribute<MasterModeOfDispensation, ArtDispensation> artDispensations;
	public static volatile SingularAttribute<MasterModeOfDispensation, Long> id;
	public static volatile SingularAttribute<MasterModeOfDispensation, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CODE = "code";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String CREATED_TIME = "createdTime";
	public static final String DESCRIPTION = "description";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ART_DISPENSATIONS = "artDispensations";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

