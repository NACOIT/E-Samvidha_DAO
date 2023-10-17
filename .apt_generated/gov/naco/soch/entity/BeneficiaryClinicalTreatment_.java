package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryClinicalTreatment.class)
public abstract class BeneficiaryClinicalTreatment_ {

	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Timestamp> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Integer> rmcFollowupFrequency;
	public static volatile SetAttribute<BeneficiaryClinicalTreatment, BeneficiaryStiRtiTreatmentDetails> teneficiaryStiRtiTreatmentDetails;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Beneficiary> masterBeneficiary;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, MasterDiagnosisRecordedAt> masterDiagnosisRecordedAt;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, MasterClinicalTreatmentType> masterClinicalTreatmentType;
	public static volatile SetAttribute<BeneficiaryClinicalTreatment, BeneficiaryAbscessTreatmentDetails> beneficiaryAbscessTreatmentDetails;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Timestamp> createdTime;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Long> id;
	public static volatile SetAttribute<BeneficiaryClinicalTreatment, BeneficiaryOpioidOverdoseTreatmentDetails> beneficiaryOpioidOverdoseTreatmentDetails;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Facility> facility;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, LocalDate> treatmentDate;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String RMC_FOLLOWUP_FREQUENCY = "rmcFollowupFrequency";
	public static final String TENEFICIARY_STI_RTI_TREATMENT_DETAILS = "teneficiaryStiRtiTreatmentDetails";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_BENEFICIARY = "masterBeneficiary";
	public static final String MASTER_DIAGNOSIS_RECORDED_AT = "masterDiagnosisRecordedAt";
	public static final String CREATED_BY = "createdBy";
	public static final String MASTER_CLINICAL_TREATMENT_TYPE = "masterClinicalTreatmentType";
	public static final String BENEFICIARY_ABSCESS_TREATMENT_DETAILS = "beneficiaryAbscessTreatmentDetails";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String BENEFICIARY_OPIOID_OVERDOSE_TREATMENT_DETAILS = "beneficiaryOpioidOverdoseTreatmentDetails";
	public static final String FACILITY = "facility";
	public static final String TREATMENT_DATE = "treatmentDate";

}

