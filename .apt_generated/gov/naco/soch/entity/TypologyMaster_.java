package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TypologyMaster.class)
public abstract class TypologyMaster_ {

	public static volatile SingularAttribute<TypologyMaster, Timestamp> modifiedTime;
	public static volatile SetAttribute<TypologyMaster, TypologyFacilityMapping> typologyFacilityMappings;
	public static volatile SingularAttribute<TypologyMaster, Integer> createdBy;
	public static volatile SingularAttribute<TypologyMaster, Boolean> isDelete;
	public static volatile SingularAttribute<TypologyMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<TypologyMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<TypologyMaster, Long> typologyId;
	public static volatile SingularAttribute<TypologyMaster, Boolean> isActive;
	public static volatile SingularAttribute<TypologyMaster, String> typologyName;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String TYPOLOGY_FACILITY_MAPPINGS = "typologyFacilityMappings";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String TYPOLOGY_ID = "typologyId";
	public static final String IS_ACTIVE = "isActive";
	public static final String TYPOLOGY_NAME = "typologyName";

}

