package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClinicalTreatmentMapping.class)
public abstract class ClinicalTreatmentMapping_ {

	public static volatile SingularAttribute<ClinicalTreatmentMapping, Timestamp> modifiedTime;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Product> product;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Role> role;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, FacilityType> facilityType;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Boolean> isDelete;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, MasterDiagnosisType> MasterDiagnosisType;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Boolean> isActive;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, String> followupFrequency;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Integer> followupCycle;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Integer> createdBy;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, MasterClinicalTreatmentType> masterClinicalTreatmentType;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Timestamp> createdTime;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, String> followupFrequencyType;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Integer> modifiedBy;
	public static volatile SingularAttribute<ClinicalTreatmentMapping, Long> id;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String PRODUCT = "product";
	public static final String ROLE = "role";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String IS_DELETE = "isDelete";
	public static final String MASTER_DIAGNOSIS_TYPE = "MasterDiagnosisType";
	public static final String IS_ACTIVE = "isActive";
	public static final String FOLLOWUP_FREQUENCY = "followupFrequency";
	public static final String FOLLOWUP_CYCLE = "followupCycle";
	public static final String CREATED_BY = "createdBy";
	public static final String MASTER_CLINICAL_TREATMENT_TYPE = "masterClinicalTreatmentType";
	public static final String CREATED_TIME = "createdTime";
	public static final String FOLLOWUP_FREQUENCY_TYPE = "followupFrequencyType";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";

}

