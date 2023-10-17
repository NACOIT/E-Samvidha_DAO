package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterDiagnosisType.class)
public abstract class MasterDiagnosisType_ {

	public static volatile SingularAttribute<MasterDiagnosisType, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterDiagnosisType, String> code;
	public static volatile SingularAttribute<MasterDiagnosisType, Integer> createdBy;
	public static volatile SingularAttribute<MasterDiagnosisType, MasterClinicalTreatmentType> masterClinicalTreatmentType;
	public static volatile SingularAttribute<MasterDiagnosisType, Boolean> isDelete;
	public static volatile SingularAttribute<MasterDiagnosisType, String> name;
	public static volatile SingularAttribute<MasterDiagnosisType, String> description;
	public static volatile SingularAttribute<MasterDiagnosisType, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterDiagnosisType, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterDiagnosisType, Long> id;
	public static volatile SingularAttribute<MasterDiagnosisType, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CODE = "code";
	public static final String CREATED_BY = "createdBy";
	public static final String MASTER_CLINICAL_TREATMENT_TYPE = "masterClinicalTreatmentType";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

