package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIStiTreatment.class)
public abstract class TIStiTreatment_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIStiTreatment, MasterKitType> kitType;
	public static volatile SingularAttribute<TIStiTreatment, LocalDate> firstFollowupDate;
	public static volatile SingularAttribute<TIStiTreatment, LocalDate> nextFollowUpDate;
	public static volatile SingularAttribute<TIStiTreatment, Boolean> isDelete;
	public static volatile SingularAttribute<TIStiTreatment, String> clinicalDetailsAbscess;
	public static volatile SingularAttribute<TIStiTreatment, Boolean> isActive;
	public static volatile SingularAttribute<TIStiTreatment, String> treatmentProvidedAbscess;
	public static volatile SingularAttribute<TIStiTreatment, Boolean> partnerNotified;
	public static volatile SingularAttribute<TIStiTreatment, LocalDate> followUpDate;
	public static volatile SingularAttribute<TIStiTreatment, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIStiTreatment, MasterDiagnosisType> diagnosisType;
	public static volatile SingularAttribute<TIStiTreatment, String> treatmentProvidedOverdose;
	public static volatile SingularAttribute<TIStiTreatment, Long> id;
	public static volatile SingularAttribute<TIStiTreatment, String> clinicalDetailsOverdose;
	public static volatile SingularAttribute<TIStiTreatment, Boolean> isEarly;
	public static volatile SingularAttribute<TIStiTreatment, Facility> facility;

	public static final String KIT_TYPE = "kitType";
	public static final String FIRST_FOLLOWUP_DATE = "firstFollowupDate";
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
	public static final String FACILITY = "facility";

}

