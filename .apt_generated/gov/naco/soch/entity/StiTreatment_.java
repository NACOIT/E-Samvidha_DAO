package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StiTreatment.class)
public abstract class StiTreatment_ {

	public static volatile SingularAttribute<StiTreatment, MasterKitType> kitType;
	public static volatile SingularAttribute<StiTreatment, LocalDate> firstFollowupDate;
	public static volatile SingularAttribute<StiTreatment, Long> facilityId;
	public static volatile SingularAttribute<StiTreatment, LocalDate> nextFollowUpDate;
	public static volatile SingularAttribute<StiTreatment, Boolean> isDelete;
	public static volatile SingularAttribute<StiTreatment, String> clinicalDetailsAbscess;
	public static volatile SingularAttribute<StiTreatment, Boolean> isActive;
	public static volatile SingularAttribute<StiTreatment, String> treatmentProvidedAbscess;
	public static volatile SingularAttribute<StiTreatment, Boolean> partnerNotified;
	public static volatile SingularAttribute<StiTreatment, LocalDate> followUpDate;
	public static volatile SingularAttribute<StiTreatment, TiBenSubEntity> beneficiary;
	public static volatile SingularAttribute<StiTreatment, MasterDiagnosisType> diagnosisType;
	public static volatile SingularAttribute<StiTreatment, String> treatmentProvidedOverdose;
	public static volatile SingularAttribute<StiTreatment, Long> id;
	public static volatile SingularAttribute<StiTreatment, String> clinicalDetailsOverdose;
	public static volatile SingularAttribute<StiTreatment, Boolean> isEarly;

	public static final String KIT_TYPE = "kitType";
	public static final String FIRST_FOLLOWUP_DATE = "firstFollowupDate";
	public static final String FACILITY_ID = "facilityId";
	public static final String NEXT_FOLLOW_UP_DATE = "nextFollowUpDate";
	public static final String IS_DELETE = "isDelete";
	public static final String CLINICAL_DETAILS_ABSCESS = "clinicalDetailsAbscess";
	public static final String IS_ACTIVE = "isActive";
	public static final String TREATMENT_PROVIDED_ABSCESS = "treatmentProvidedAbscess";
	public static final String PARTNER_NOTIFIED = "partnerNotified";
	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String DIAGNOSIS_TYPE = "diagnosisType";
	public static final String TREATMENT_PROVIDED_OVERDOSE = "treatmentProvidedOverdose";
	public static final String ID = "id";
	public static final String CLINICAL_DETAILS_OVERDOSE = "clinicalDetailsOverdose";
	public static final String IS_EARLY = "isEarly";

}

