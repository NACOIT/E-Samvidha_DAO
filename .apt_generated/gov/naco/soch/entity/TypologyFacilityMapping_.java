package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TypologyFacilityMapping.class)
public abstract class TypologyFacilityMapping_ {

	public static volatile SingularAttribute<TypologyFacilityMapping, Timestamp> modifiedTime;
	public static volatile SingularAttribute<TypologyFacilityMapping, Integer> createdBy;
	public static volatile SingularAttribute<TypologyFacilityMapping, Boolean> isDelete;
	public static volatile SingularAttribute<TypologyFacilityMapping, Timestamp> createdTime;
	public static volatile SingularAttribute<TypologyFacilityMapping, Integer> modifiedBy;
	public static volatile SingularAttribute<TypologyFacilityMapping, Boolean> isActive;
	public static volatile SingularAttribute<TypologyFacilityMapping, Facility> facility;
	public static volatile SingularAttribute<TypologyFacilityMapping, Long> typologyFacilityMappingId;
	public static volatile SingularAttribute<TypologyFacilityMapping, Long> typologyTarget;
	public static volatile SingularAttribute<TypologyFacilityMapping, TypologyMaster> typologyMaster;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String TYPOLOGY_FACILITY_MAPPING_ID = "typologyFacilityMappingId";
	public static final String TYPOLOGY_TARGET = "typologyTarget";
	public static final String TYPOLOGY_MASTER = "typologyMaster";

}

